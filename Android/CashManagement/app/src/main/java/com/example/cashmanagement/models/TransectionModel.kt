package com.example.cashmanagement.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity(tableName = "transections")
@Parcelize
data class TransectionModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "cat_id")
    val catId: Int,

    val type: Int,

    val amount: Double,

    @ColumnInfo(name = "datetime")
    val dateTime: String
): Parcelable