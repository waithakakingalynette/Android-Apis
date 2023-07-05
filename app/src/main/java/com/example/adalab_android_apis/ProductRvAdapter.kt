package com.example.adalab_android_apis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adalab_android_apis.databinding.ProductListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductRvAdapter(var productList:List<Products>): RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding=ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct=productList[position]
        var binding=holder.binding
        binding.tvid.text=currentProduct.id.toString()
        binding.tvtitle.text=currentProduct.title
        binding.tvdescription.text= currentProduct.description
        binding.tvprice.text= currentProduct.price.toString()
        binding.tvrating.text= currentProduct.rating.toString()
        binding.tvstock.text= currentProduct.stock.toString()
        binding.tvcategory.text= currentProduct.category
        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(80,80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivavator)
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}

class ProductViewHolder(var binding:ProductListItemBinding): RecyclerView.ViewHolder(binding.root)

