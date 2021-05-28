package com.indovision.belanja.ui.cart

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indovision.belanja.R
import com.indovision.belanja.data.source.local.UserPreference
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.ActivityCartBinding
import com.indovision.belanja.viewmodel.CartViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class CartActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCartBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.uicons_angle_small_left)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        viewModel = ViewModelProvider(this, factory)[CartViewModel::class.java]

        getData()
    }

    private fun getData() {
        viewModel.getCart(UserPreference(this).getUserId())
            .observe(this, {
                with(viewBinding){
                    val adapter = CartAdapter(it)

                    rvCartList.setHasFixedSize(true)
                    rvCartList.layoutManager = LinearLayoutManager(this@CartActivity)
                    rvCartList.adapter = adapter
                }
            })
    }
}
