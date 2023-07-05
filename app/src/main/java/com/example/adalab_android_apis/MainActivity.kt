package com.example.adalab_android_apis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adalab_android_apis.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        getProduct()
    }

   private fun getProduct(){
        val apiClient=ApiClients.buildApiClient(ApiInterface::class.java)
        val request=apiClient.getProduct()
        request.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful){
                    val products=response.body()?.products
                    var productadapter=ProductRvAdapter(products?: emptyList())
                    binding.rvadapter.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.rvadapter.adapter=productadapter
                    Toast.makeText(baseContext,"Fetched ${products?.size} products",Toast.LENGTH_LONG)
                        .show()
                }
                else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}