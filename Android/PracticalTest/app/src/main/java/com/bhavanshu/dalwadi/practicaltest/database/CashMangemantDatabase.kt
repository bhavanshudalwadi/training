package com.bhavanshu.dalwadi.practicaltest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhavanshu.dalwadi.practicaltest.models.CategoryModel
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel

@Database(entities = [CategoryModel::class, ContactModel::class], version = 1)
abstract class CashMangemantDatabase: RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getContactDao(): ContactDao

    companion object {
        @Volatile
        private var instance: CashMangemantDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CashMangemantDatabase::class.java,
            "practical_test_db"
        ).build()
    }
}