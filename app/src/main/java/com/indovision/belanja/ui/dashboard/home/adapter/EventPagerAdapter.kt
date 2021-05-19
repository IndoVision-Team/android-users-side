package com.indovision.belanja.ui.dashboard.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.indovision.belanja.R
import com.indovision.belanja.data.EventEntity
import com.indovision.belanja.databinding.ItemViewPagerBinding

class EventPagerAdapter(
    private val context: Context,
    private val listEvent: List<EventEntity>) : PagerAdapter() {
    override fun getCount(): Int {
        return listEvent.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemViewPagerBinding.inflate(layoutInflater, container, false)
        Glide.with(context).load(listEvent[position].imagePath).into(binding.ivViewPager)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }
}