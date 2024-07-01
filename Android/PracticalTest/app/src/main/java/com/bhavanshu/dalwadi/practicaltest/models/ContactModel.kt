package com.bhavanshu.dalwadi.practicaltest.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "contacts")
@Parcelize
data class ContactModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val image: String,

    val firstName: String,
    val lastName: String,
    val mobileNumber: String,
    val email: String,

    @ColumnInfo(name = "cat_id")
    val catId: Int,
): Parcelable