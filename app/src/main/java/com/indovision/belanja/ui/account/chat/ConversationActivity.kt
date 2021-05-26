package com.indovision.belanja.ui.account.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indovision.belanja.R
import com.indovision.belanja.databinding.ActivityConversationBinding

class ConversationActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConversationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityConversationBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.uicons_angle_small_left)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
