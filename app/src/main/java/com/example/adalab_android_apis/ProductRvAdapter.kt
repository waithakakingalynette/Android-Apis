package com.example.adalab_android_apis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adalab_android_apis.databinding.ProductListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsAdapter( var productlist: List<Products>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productlist.get(position)
        val binding = holder.binding
        binding.tvid.text = currentProduct.title
        binding.tvtitle.text = currentProduct.description
        binding.tvdescription.text = currentProduct.category
        binding.tvprice.text = currentProduct.rating
        binding.tvrating.text = currentProduct.stock.toString()
        binding.tvstock.text = currentProduct.id.toString()
        binding.tvcategory.text = currentProduct.Price.toString()

        Picasso
            .get()
            .load (currentProduct.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
////            .resize(80,80)
////            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivavator)


    }

    override fun getItemCount(): Int {
        return productlist.size
    }
}
class ProductViewHolder(var binding: ProductListItemBinding): RecyclerView.ViewHolder(binding.root){

}