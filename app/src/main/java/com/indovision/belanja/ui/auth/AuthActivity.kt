package com.indovision.belanja.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indovision.belanja.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}
