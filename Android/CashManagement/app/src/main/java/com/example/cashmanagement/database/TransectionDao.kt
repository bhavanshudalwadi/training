package com.example.cashmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cashmanagement.models.TransectionModel

@Dao
interface TransectionDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTransection(category: TransectionModel)

    @Update
    suspend fun updateTransection(category: TransectionModel)

    @Delete
    suspend fun deleteTransection(category: TransectionModel)

    @Query("SELECT * FROM transections ORDER BY id DESC")
    fun getAllTransection(): LiveData<List<TransectionModel>>

    @Query("SELECT * FROM transections WHERE id = :id")
    fun getTransectionById(id: Int): LiveData<List<TransectionModel>>
}