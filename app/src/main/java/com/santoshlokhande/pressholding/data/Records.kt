package com.santoshlokhande.pressholding.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Santosh Lokhande on 07/9/2019
 *
 * Records is Data class
 *
 * All field of this class works as a column name of record_table
 *
 */

@Entity(tableName = "record_table")
data class Records(
        @PrimaryKey
        val _id: Int,
        val volume_of_mobile_data: String,
        val quarter: String
)

data class RecordResponse(
        val records: List<Records>
)