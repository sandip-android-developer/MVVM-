package com.mvvmarcheitecture1.view.base

import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.view.cart.CartFragment
import com.mvvmarcheitecture1.view.dashboard.DashboardFragment
import com.mvvmarcheitecture1.view.home.BlankFragment
import com.mvvmarcheitecture1.view.home.BlankFragment2
import com.mvvmarcheitecture1.view.home.BlankFragment3
import com.mvvmarcheitecture1.view.home.HomeFragment
import com.mvvmarcheitecture1.view.notifications.NotificationsFragment
import java.util.*

open class BaseActivity : AppCompatActivity() {
    var fragmentBackStack: Stack<Fragment>? = null
    lateinit var controller: NavController
    var doubleBackToExitPressedOnce: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        fragmentBackStack = Stack()
    }

    override fun onBackPressed() {
        // super.onBackPressed()
        var navBaseHostFragment = supportFragmentManager.primaryNavigationFragment
        var backFragmentStacCount = navBaseHostFragment?.childFragmentManager?.backStackEntryCount
        if (backFragmentStacCount == null) {
            return
        }
        if (backFragmentStacCount < 1) {
            doubleTapOnBackPress()
        } else {
            var currentFragment: Fragment =
                navBaseHostFragment!!.getChildFragmentManager().getFragments().get(0)
            controller = Navigation.findNavController(this, R.id.nav_host_fragment)
            if (currentFragment is HomeFragment) {
                Log.d("TAG", "onBackPressed: " + "Home Fragment")
                finish()
            } else if (currentFragment is DashboardFragment) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_navigation_dashboard_to_navigation_home,
                    null,
                    navOptions
                )

            } else if (currentFragment is CartFragment) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_navigation_cart_to_navigation_home,
                    null,
                    navOptions
                )

            } else if (currentFragment is NotificationsFragment) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_navigation_notifications_to_navigation_home,
                    null,
                    navOptions
                )

            } else if (currentFragment is BlankFragment) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_blankFragment_to_navigation_home,
                    null,
                    navOptions
                )

            } else if (currentFragment is BlankFragment2) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_blankFragment2_to_blankFragment,
                    null,
                    navOptions
                )

            } else if (currentFragment is BlankFragment3) {
                var navOptions: NavOptions =
                    NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build()
                controller.navigate(
                    R.id.action_blankFragment3_to_blankFragment2,
                    null,
                    navOptions
                )

            }
        }

    }

    fun doubleTapOnBackPress() {
        if (doubleBackToExitPressedOnce) {
            finish()
            /*overridePendingTransition(
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )*/
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(
            this@BaseActivity,
            getString(R.string.press_back),
            Toast.LENGTH_SHORT
        ).show()
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, 1000)

    }
}