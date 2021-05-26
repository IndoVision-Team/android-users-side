package com.indovision.belanja.ui.dashboard.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indovision.belanja.data.source.local.UserPreference
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.FragmentHomeBinding
import com.indovision.belanja.ui.dashboard.ItemProductClickListener
import com.indovision.belanja.ui.dashboard.home.adapter.AdsPagerAdapter
import com.indovision.belanja.ui.dashboard.home.adapter.EventPagerAdapter
import com.indovision.belanja.ui.dashboard.home.adapter.ProductRecommendationAdapter
import com.indovision.belanja.ui.detail.DetailProductActivity
import com.indovision.belanja.ui.detail.DetailProductActivity.Companion.EXTRA_ID
import com.indovision.belanja.viewmodel.HomeViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        getData()

        return binding.root
    }

    private fun getData() {
        viewModel.getEvents().observe(viewLifecycleOwner, {
            val adapter = EventPagerAdapter(it)
            with(binding) {
                viewpagerEvent.adapter = adapter
                dotIndicatorEvent.setViewPager2(viewpagerEvent)
            }
        })

        viewModel.getAds().observe(viewLifecycleOwner, {
            val adapter = AdsPagerAdapter(it)
            with(binding) {
                viewpagerAds.adapter = adapter
                dotIndicatorAds.setViewPager2(viewpagerAds)
            }
        })

        viewModel.getRecommendations(UserPreference(context as Context).getUserId())
            .observe(viewLifecycleOwner, {
                val adapter = ProductRecommendationAdapter(it, object : ItemProductClickListener {
                    override fun onItemClickListener(productId: String) {
                        val intent = Intent(context, DetailProductActivity::class.java)
                        intent.putExtra(EXTRA_ID, productId)
                        startActivity(intent)
                    }
                })
                with(binding) {
                    rvRecommendationList.adapter = adapter
                    rvRecommendationList.setHasFixedSize(true)
                    rvRecommendationList.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
