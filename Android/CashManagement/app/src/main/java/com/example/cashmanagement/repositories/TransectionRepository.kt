package com.example.cashmanagement.repositories

import com.example.cashmanagement.database.CashMangemantDatabase
import com.example.cashmanagement.models.TransectionModel

class TransectionRepository(private val db: CashMangemantDatabase) {
    suspend fun insertTransection(transection: TransectionModel) = db.getTransectionDao().insertTransection(transection)
    suspend fun updateTransection(transection: TransectionModel) = db.getTransectionDao().updateTransection(transection)
    suspend fun deleteTransection(transection: TransectionModel) = db.getTransectionDao().deleteTransection(transection)

    fun getAllTransection() = db.getTransectionDao().getAllTransection()
    fun getTransectionById(id: Int) = db.getTransectionDao().getTransectionById(id)
}