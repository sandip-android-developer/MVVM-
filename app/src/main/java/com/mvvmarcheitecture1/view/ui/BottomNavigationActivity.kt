package com.mvvmarcheitecture1.view.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.view.base.BaseActivity
import com.mvvmarcheitecture1.view.cart.CartFragment
import com.mvvmarcheitecture1.view.dashboard.DashboardFragment
import com.mvvmarcheitecture1.view.home.HomeFragment
import com.mvvmarcheitecture1.view.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : BaseActivity() {
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        toolbar = supportActionBar!!
        //navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
            var navController = findNavController(R.id.nav_host_fragment)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            var appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_home, R.id.navigation_dashboard,R.id.navigation_cart, R.id.navigation_notifications
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    toolbar.title = "Songs"
                    val songsFragment = HomeFragment.newInstance()
                    openFragment(songsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    toolbar.title = "Albums"
                    val albumsFragment = DashboardFragment.newInstance()
                    openFragment(albumsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_cart -> {
                    toolbar.title = "Artists"
                    val artistsFragment = CartFragment.newInstance()
                    openFragment(artistsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    toolbar.title = "Artists"
                    val artistsFragment = NotificationsFragment.newInstance()
                    openFragment(artistsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}