package com.example.cashmanagement.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "budgets")
@Parcelize
data class BudgetModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "cat_id")
    val catId: Int,

    val amount: Double,
): Parcelable