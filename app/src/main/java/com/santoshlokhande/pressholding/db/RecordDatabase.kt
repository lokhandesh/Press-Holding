package com.santoshlokhande.pressholding.db


import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.santoshlokhande.pressholding.data.Records
import com.santoshlokhande.pressholding.db.dao.RecordsDao

/**
 * Created by Santosh Lokhande 07/09/2019
 *
 * This class has used to instantiate Room Database.
 *
 *
 */

@Database(entities = [Records::class], version = 1)
abstract class RecordDatabase : RoomDatabase() {

    abstract fun albumDao(): RecordsDao

    companion object {
        private var instance: RecordDatabase? = null

        fun  getInstance(context: Context): RecordDatabase? {
            if (instance == null) {
                synchronized(RecordDatabase::class) {
                    instance = Room.databaseBuilder(
                        context,
                        RecordDatabase::class.java, "record_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback).allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }

    }

}