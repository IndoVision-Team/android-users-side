package com.indovision.belanja.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.databinding.ItemViewPagerBinding

class ProductImagePagerAdapter(private val productImages: Array<String>) :
    RecyclerView.Adapter<ProductImagePagerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductImagePagerAdapter.ViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductImagePagerAdapter.ViewHolder, position: Int) {
        holder.bind(productImages[position])
    }

    override fun getItemCount(): Int = productImages.size

    inner class ViewHolder(private val binding: ItemViewPagerBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(imagePath: String){
                Glide.with(itemView.context).load(imagePath)
                    .into(binding.ivViewPager)
            }

    }

}