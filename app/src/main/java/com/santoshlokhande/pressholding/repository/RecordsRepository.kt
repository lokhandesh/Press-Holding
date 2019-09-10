package com.santoshlokhande.pressholding.repository

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.santoshlokhande.pressholding.data.RecordResponse
import com.santoshlokhande.pressholding.data.Records
import com.santoshlokhande.pressholding.db.RecordDatabase
import com.santoshlokhande.pressholding.db.dao.RecordsDao
import com.santoshlokhande.pressholding.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Santosh Lokhande on 07/9/2019
 *
 * This class is used to communicate with RoomDb and Network Call
 *
 * @param Context
 *
 * In init block we initialise RecordDatabase class.
 *
 */

class RecordsRepository(application: Application) {

    private var recordDao: RecordsDao
    private var allRecordData: LiveData<List<Records>>
    private var errorString = MutableLiveData<String>()


    init {
        val database: RecordDatabase = RecordDatabase.getInstance(
            application
        )!!
        recordDao = database.albumDao()
        allRecordData = recordDao.getAllRecordList()

    }

    fun getAllRecordList(): LiveData<List<Records>> {
        return allRecordData
    }

    fun getError(): LiveData<String> {
        return errorString
    }

    fun insert(records: List<Records>) {
        val insertAlbumListAsyncTask = InsertAlbumListAsyncTask(recordDao).execute(records)
    }

    fun retriveRecordList(limit:Int) {

        ApiClient.apiInterface.getRecords("a807b7ab-6cad-4aa6-87d0-e283a7353a0f",limit).enqueue(object : Callback<RecordResponse> {

            override fun onFailure(call: Call<RecordResponse>, t: Throwable) {
               // TODO:: Need to implement failure condition
                errorString.value = t.stackTrace.toString()
            }
            override fun onResponse(call: Call<RecordResponse>, response: Response<RecordResponse>) {

                var recordList: List<Records>? = response.body()?.result?.records
                insert(recordList!!)

            }

        })
    }

    private class InsertAlbumListAsyncTask(recordsDao: RecordsDao) : AsyncTask<List<Records>, Unit, Unit>() {
        val recordsDao = recordsDao

        override fun doInBackground(vararg p0: List<Records>?) {
            recordsDao.deleteAll()
            recordsDao.insert(p0[0]!!)
        }

    }

}