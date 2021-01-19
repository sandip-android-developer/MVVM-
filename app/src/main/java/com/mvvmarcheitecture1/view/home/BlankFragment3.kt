package com.mvvmarcheitecture1.view.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.view.base.BaseActivity


class BlankFragment3 : Fragment() {
    var mActivity: BaseActivity?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(activity as Activity,R.id.nav_host_fragment)
        mActivity=activity as BaseActivity
        val button: Button = requireView()!!.findViewById(R.id.button_frag3)

        button.setOnClickListener(View.OnClickListener {
            navController.navigateUp()

           /* navController.addOnNavigatedListener(object : OnNavigatedListener() {
                fun onNavigated(
                    @NonNull controller: NavController?,
                    @NonNull destination: NavDestination
                ) {
                    Log.d("TAG", destination.label.toString() + " ")
                }
            })*/
        })
    }

}