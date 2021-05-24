package com.indovision.belanja.ui.dashboard.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indovision.belanja.data.ProductEntity
import com.indovision.belanja.databinding.ItemProductGridBinding
import com.indovision.belanja.ui.dashboard.ItemProductClickListener

class SearchAdapter(
    private val productList: List<ProductEntity>,
    private val callback: ItemProductClickListener
) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val binding = ItemProductGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    inner class ViewHolder(private val binding: ItemProductGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productEntity: ProductEntity) {
            with(binding) {
                productTitle.text = productEntity.name
                productLocations.text =
                    productEntity.shopEntity.address
                        .substringAfter("Kec.")
                        .substringBefore("Kab.")
                productPrices.text = productEntity.price
                Glide.with(itemView.context).load(productEntity.imagePath[0])
                    .into(productImages)
                itemView.setOnClickListener { callback.onItemClickListener(productEntity.id) }
            }
        }

    }
}