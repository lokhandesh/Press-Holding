package com.myproject.albumlist.data

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
        val id: Int,
        val userId: Int,
        val title: String
)

data class AlbumResponse(
        val results: List<Records>
)