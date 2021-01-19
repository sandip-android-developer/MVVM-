package com.mvvmarcheitecture1.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.service.model.response.User
import com.mvvmarcheitecture1.view.home.HomeAdapter
import com.mvvmarcheitecture1.utils.SettingsManager

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: HomeAdapter
    lateinit var settingsManager: SettingsManager
    private var isDarkMode = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  settingsManager = SettingsManager(applicationContext)
        //setupUI()
     /*   setupViewModel()
        setupObserver()*/
    }

  /*  private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this, arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter

    }*/

   /* private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)

    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
*/

    private fun renderList(users: List<User>) {
       /* adapter.addData(users)
        adapter.notifyDataSetChanged()*/
        // with Preferences DataStore
    }


}