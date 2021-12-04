package com.machinetest.testproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.machinetest.testproject.R
import com.machinetest.testproject.fragments.homeviewmodel.HomeViewModel
import com.machinetest.testproject.utility.Utility
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private var imageList: ArrayList<String>? = null
    private var adapter: HomeImageAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        imageList = ArrayList()
        homeViewModel.mutablePostList.observe(viewLifecycleOwner) {
            if (it != null) {
                if (!it.equals(null)) {
                    setRecyclerView(it)
                }

            }
        }

        homeViewModel.errorResponse.observe(viewLifecycleOwner) {
            Utility.showToast(
                mActivity,
                it
            )
        }
        setProgressBar(homeViewModel.progressDialog)
        homeViewModel.fetchHomeData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecyclerView(list: ArrayList<String>?) {
        if (list == null) {
            return
        }
        if (list.size > 0) {
            imageList?.addAll(list)
        }
        if (adapter == null) {
            rec_images.layoutManager = LinearLayoutManager(mActivity)
            adapter = HomeImageAdapter(mActivity, imageList)
            rec_images.adapter = adapter
            val helper: SnapHelper = LinearSnapHelper()
            helper.attachToRecyclerView(rec_images)
        } else {
            adapter?.notifyDataSetChanged()
        }
    }

}