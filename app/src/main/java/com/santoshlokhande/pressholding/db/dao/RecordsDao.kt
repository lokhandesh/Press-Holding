package com.santoshlokhande.pressholding.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.myproject.albumlist.data.Records

/**
 * Created by Santosh Lokhande on 07/9/2019.
 *
 * Here we declare method for Room Db
 *
 * THis interface should annotate with @Dao
 *
 */

@Dao
interface RecordsDao {

    @Insert
    fun insert(users: List<Records>)

    @Query("SELECT * FROM record_table ")
    fun getAllAlbumList(): LiveData<List<Records>>

    @Query("DELETE FROM record_table")
    fun deleteAll()

}