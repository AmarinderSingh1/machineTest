package com.machinetest.testproject.fragments.homeviewmodel

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.machinetest.testproject.CommonViewModel
import com.machinetest.testproject.fragments.homeviewmodel.HomeScreenResponse
import com.machinetest.testproject.networks.BackEndApi
import com.machinetest.testproject.networks.WebServiceClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeViewModel(application: Application) : CommonViewModel(application) {

    val mutablePostList: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val errorResponse: MutableLiveData<String> = MutableLiveData()
    val progressDialog: MutableLiveData<Boolean> = MutableLiveData()

    fun fetchHomeData() {
        progressDialog.value = true
        val apiServices = WebServiceClient.client.create(BackEndApi::class.java)
        var response: Response<ArrayList<String>>?
        CoroutineScope(Dispatchers.IO).launch {
            try {
                response = apiServices.getImages()
                withContext(Dispatchers.Main) {
                    progressDialog.value = false
                    if (response != null) {
                        mutablePostList.postValue(response!!.body())
                    }
                }
            } catch (e: Exception) {
                Handler(Looper.getMainLooper()).post(kotlinx.coroutines.Runnable {
                    progressDialog.value = false
                    errorResponse.value =  e.message
                })
            }
        }
    }
}