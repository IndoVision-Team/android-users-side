package com.indovision.belanja.ui.dashboard.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.databinding.ItemViewPagerBinding

class EventPagerAdapter(private val listEvent: List<EventEntity>) :
    RecyclerView.Adapter<EventPagerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventPagerAdapter.ViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventPagerAdapter.ViewHolder, position: Int) {
        holder.bind(listEvent[position])
    }

    override fun getItemCount(): Int = listEvent.size

    inner class ViewHolder(private val binding: ItemViewPagerBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(eventEntity: EventEntity){
                Glide.with(itemView.context).load(eventEntity.imagePath)
                    .into(binding.ivViewPager)
            }

    }

}