package com.example.cashmanagement.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cashmanagement.models.BudgetModel
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.models.TransectionModel

@Database(entities = [BudgetModel::class, CategoryModel::class, TransectionModel::class], version = 1)
abstract class CashMangemantDatabase: RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getBudgetDao(): BudgetDao
    abstract fun getTransectionDao(): TransectionDao

    companion object {
        @Volatile
        private var instance: CashMangemantDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance?:createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CashMangemantDatabase::class.java,
            "cash_mangemant_db"
        ).build()
    }
}