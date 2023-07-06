package com.example.adalab_android_apis

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    fun getProducts(): Call<ProductsResponse>

    @GET("/product/{id}")
    fun getProductsbyId(@Path("id") productId: Int): Call<Products>
}