package com.santoshlokhande.pressholding.service

import com.santoshlokhande.pressholding.data.RecordResponse
import com.santoshlokhande.pressholding.data.Records
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Santosh Lokhande on 07/9/2019
 */

interface ApiInterface {

    @GET("datastore_search")
    fun getRecords(@Query("resource_id") id:String,@Query("limit") limit:Int): Call<RecordResponse>


}