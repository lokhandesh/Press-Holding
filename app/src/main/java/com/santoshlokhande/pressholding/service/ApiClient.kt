package com.santoshlokhande.pressholding.service

import android.util.Log
import com.myproject.albumlist.service.HttpConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Santosh Lokhande on 07/9/2019
 *
 * Here we have added retrofit builder.
 *
 *
 */

public object ApiClient {

    val apiInterface: ApiInterface
    private val retrofit: Retrofit
    private val DEFAULT_TIMEOUT = 5L
    private val okHttpClient: OkHttpClient

    init {
        val longging = Interceptor { chain ->
            val request = chain.request()
            Log.d("okhttp", "request" + request.url().toString())
            chain.proceed(request)
        }
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(longging)
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(HttpConstants.BASE_URL)
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

}