package com.machinetest.testproject.networks

import com.google.gson.GsonBuilder
import com.machinetest.testproject.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebServiceClient {
    companion object {
        val client: Retrofit
            get() {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS).addInterceptor { chain: Interceptor.Chain ->
                        val request = chain.request().newBuilder()
                            .build()
                        chain.proceed(request)
                    }
                    .addInterceptor(interceptor).build()
                val jsonBuilder = GsonBuilder()
                    .setLenient()
                    .create()
                return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(jsonBuilder))
                    .client(client)
                    .build()
            }
    }
}