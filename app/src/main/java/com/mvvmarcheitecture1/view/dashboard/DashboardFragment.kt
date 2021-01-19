package com.mvvmarcheitecture1.view.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.view.base.BaseActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {


    var mActivity: BaseActivity? = null
    var dashboardPagedlistAdapter: DashboardPagedlistAdapter? = null
    var dashboardViewModel: DashboardViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* dashboardViewModel =
             ViewModelProviders.of(this).get(DashboardViewModel::class.java)
         val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
         val textView: TextView = root.findViewById(R.id.text_dashboard)
         dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
             textView.text = it
         })*/
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    companion object {
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as BaseActivity
        dashboardViewModel = ViewModelProvider(mActivity!!).get(DashboardViewModel::class.java)
        initView()
    }

    private fun initView() {
        dashboardPagedlistAdapter = DashboardPagedlistAdapter()
        rvDashboard.apply {
            layoutManager = LinearLayoutManager(mActivity)
            setHasFixedSize(true)
            adapter = dashboardPagedlistAdapter
        }
        viewLifecycleOwner.lifecycleScope.launch {
            dashboardViewModel!!.photoList.collectLatest {
                dashboardPagedlistAdapter!!.submitData(it)
            }
        }
    }
}