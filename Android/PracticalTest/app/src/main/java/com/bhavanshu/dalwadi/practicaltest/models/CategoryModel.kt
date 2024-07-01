package com.bhavanshu.dalwadi.practicaltest.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "categories")
@Parcelize
data class CategoryModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String
): Parcelable