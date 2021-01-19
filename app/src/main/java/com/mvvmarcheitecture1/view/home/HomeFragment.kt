package com.mvvmarcheitecture1.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.service.model.response.User
import com.mvvmarcheitecture1.utils.Status
import com.mvvmarcheitecture1.view.base.BaseActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var homeViewModel: HomeViewModel? = null
    var adapter: HomeAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
        /*  val textView: TextView = root.findViewById(R.id.text_home)
          homeViewModel.text.observe(viewLifecycleOwner, Observer {
              textView.text = it
          })*/
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
        var mActivity: BaseActivity? = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as BaseActivity
        homeViewModel = ViewModelProvider(
            mActivity!!/*,
            ViewModelFactory(RetrofitBuilder.apiService)*/
        ).get(HomeViewModel::class.java)

        //  setupViewModel()
        setupUI()
        setupObservers()

    }

    private fun setupViewModel() {

    }

    private fun setupUI() {
        recyclerViewhome?.layoutManager = LinearLayoutManager(mActivity!!)
        adapter = HomeAdapter(mActivity!!, arrayListOf()!!)
        recyclerViewhome?.addItemDecoration(
            DividerItemDecoration(
                mActivity!!,
                (recyclerViewhome?.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerViewhome.adapter = adapter
    }

    private fun setupObservers() {
        homeViewModel!!.getUsers().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerViewhome.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        recyclerViewhome.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerViewhome.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {

        adapter!!.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}