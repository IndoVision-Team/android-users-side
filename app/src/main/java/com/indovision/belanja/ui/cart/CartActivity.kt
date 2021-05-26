package com.indovision.belanja.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indovision.belanja.R
import com.indovision.belanja.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.uicons_angle_small_left)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
