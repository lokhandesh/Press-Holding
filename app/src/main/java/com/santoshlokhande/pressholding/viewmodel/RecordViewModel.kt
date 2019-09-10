package com.santoshlokhande.pressholding.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.santoshlokhande.pressholding.data.RecordResponse
import com.santoshlokhande.pressholding.repository.RecordsRepository
import com.santoshlokhande.pressholding.data.Records

/**
 * Created by Santosh Lokhande on 07/9/2019
 *
 * RecordViewModel which is extended from AndroidViewModel.
 *
 * Here we received all RecordList from RoomDb.
 *
 */


class RecordViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: RecordsRepository = RecordsRepository(application)

    private var recordList: LiveData<List<Records>> = repository.getAllRecordList()



    fun getAllRecords(limit: Int): LiveData<List<Records>> {
        return recordList
    }

    fun retriveRecordList(limit:Int){
        repository.retriveRecordList(limit)
    }

    fun retriveError() : LiveData<String>{
        return repository.getError()
    }




}