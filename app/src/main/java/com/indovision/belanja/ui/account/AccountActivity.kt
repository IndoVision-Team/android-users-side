package com.indovision.belanja.ui.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.indovision.belanja.R
import com.indovision.belanja.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // setup navigation host
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.uicons_angle_small_left)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        viewBinding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
