package com.indovision.belanja.ui.account.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indovision.belanja.data.MenuEntity
import com.indovision.belanja.databinding.ItemUserMenuBinding

class MenuAdapter(private val menuList: ArrayList<MenuEntity>) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val binding =
            ItemUserMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int = menuList.size

    inner class ViewHolder(private val binding: ItemUserMenuBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(menuEntity: MenuEntity) {
            with(binding){
                menuTitle.text = menuEntity.name
                Glide.with(itemView.context).apply { RequestOptions.overrideOf(54, 54) }
                    .load(menuEntity.iconPath).into(menuIcon)
            }
        }
    }
}