package com.indovision.belanja.ui.dashboard.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indovision.belanja.data.AdsEntity
import com.indovision.belanja.databinding.ItemViewPagerBinding

class AdsPagerAdapter(private val listAds: List<AdsEntity>) :
    RecyclerView.Adapter<AdsPagerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdsPagerAdapter.ViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdsPagerAdapter.ViewHolder, position: Int) {
        holder.bind(listAds[position])
    }

    override fun getItemCount(): Int = listAds.size

    inner class ViewHolder(private val binding: ItemViewPagerBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(adsEntity: AdsEntity){
                Glide.with(itemView.context).load(adsEntity.imagePath)
                    .into(binding.ivViewPager)
            }

    }

}