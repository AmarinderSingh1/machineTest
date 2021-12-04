package com.machinetest.testproject.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.machinetest.testproject.MainActivity

open class BaseFragment : Fragment() {
    protected lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            this.mActivity = context
        }
    }

    open fun setProgressBar(progressBar: MutableLiveData<Boolean>) {
        progressBar.observe(this) { aBoolean: Boolean ->
            if (aBoolean) {
                mActivity.showProgress()
            } else {
                mActivity.hideProgress()
            }
        }
    }
}
