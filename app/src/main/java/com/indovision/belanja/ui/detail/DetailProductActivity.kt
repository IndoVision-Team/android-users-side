package com.indovision.belanja.ui.detail

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.indovision.belanja.R
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.ActivityDetailProductBinding
import com.indovision.belanja.ui.detail.adapter.ProductImagePagerAdapter
import com.indovision.belanja.viewmodel.DetailProductViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class DetailProductActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var viewBinding: ActivityDetailProductBinding
    private lateinit var viewModel : DetailProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.uicons_angle_small_left,
                theme
            )
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        viewModel = ViewModelProvider(this, factory)[DetailProductViewModel::class.java]

        getData()
    }

    private fun getData() {
        viewModel.getProductDetail(intent.getStringExtra(EXTRA_ID).toString())
            .observe(this,{
                val viewPagerAdapter = ProductImagePagerAdapter(it.imagePath)
                with(viewBinding){
                    vpProductImages.adapter = viewPagerAdapter
                    dotIndicatorImages.setViewPager2(vpProductImages)
                    productDescriptions.text = it.description
                    productPrices.text = it.price
                    productTitle.text = it.name
                    shopAddress.text = it.shopEntity.address
                    shopName.text = it.shopEntity.name
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
