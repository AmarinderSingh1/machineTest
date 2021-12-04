package com.machinetest.testproject.networks

import com.machinetest.testproject.fragments.homeviewmodel.HomeScreenResponse
import retrofit2.Response
import retrofit2.http.*


interface BackEndApi {

    @GET("/api/shibes?count=50&urls=true&httpsUrls=true")
    suspend fun getImages(): Response<ArrayList<String>>

}