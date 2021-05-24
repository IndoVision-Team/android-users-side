package com.indovision.belanja.ui.dashboard.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.databinding.ItemProductListBinding
import com.indovision.belanja.ui.dashboard.home.ItemProductClickListener

class ProductRecommendationAdapter(
    private val listProduct: List<ProductEntity>,
    private val callback: ItemProductClickListener) :
    RecyclerView.Adapter<ProductRecommendationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRecommendationAdapter.ViewHolder {
        val binding = ItemProductListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRecommendationAdapter.ViewHolder, position: Int) {
        holder.bind(listProduct[position])
    }

    override fun getItemCount(): Int = listProduct.size

    inner class ViewHolder(private val binding: ItemProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productEntity: ProductEntity) {
            with(binding) {
                productTitle.text = productEntity.name
                productLocations.text =
                    productEntity.shopEntity.address
                        .substringAfter("Kec.")
                        .substringBefore("Kab.")
                Glide.with(itemView.context).load(productEntity.imagePath[0])
                    .into(productImages)
                itemView.setOnClickListener { callback.onItemClickListener(productEntity.id) }
            }
        }

    }

}