package com.bhavanshu.dalwadi.practicaltest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertContact(category: ContactModel)

    @Update
    suspend fun updateContact(category: ContactModel)

    @Delete
    suspend fun deleteContact(category: ContactModel)

    @Query("SELECT * FROM contacts ORDER BY id DESC")
    fun getAllContact(): LiveData<List<ContactModel>>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactById(id: Int): LiveData<List<ContactModel>>
}