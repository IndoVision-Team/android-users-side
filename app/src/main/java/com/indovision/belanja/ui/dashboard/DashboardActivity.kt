package com.indovision.belanja.ui.dashboard

import android.app.SearchManager
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.indovision.belanja.R
import com.indovision.belanja.databinding.ActivityDashboardBinding
import kotlin.math.abs

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // setup navigation host
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setSupportActionBar(viewBinding.toolbar)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        viewBinding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu, menu)
        // listener when layout is scrolling
        viewBinding.appBar.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (abs(verticalOffset) == appBarLayout.totalScrollRange) {
                    supportActionBar?.setDisplayShowTitleEnabled(true)
                } else if (verticalOffset <= 0) {
                    supportActionBar?.setDisplayShowTitleEnabled(false)
                }
            }
        )
        // setup search view
        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Search"

        // change search view text color
        val searchAutoComplete: SearchView.SearchAutoComplete =
            searchView.findViewById(androidx.appcompat.R.id.search_src_text)
        searchAutoComplete.setTextColor(resources.getColor(R.color.cello))
        searchAutoComplete.setHintTextColor(resources.getColor(R.color.hint))

        return super.onCreateOptionsMenu(menu)
    }
}
