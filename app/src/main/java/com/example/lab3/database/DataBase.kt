package com.example.lab3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab3.dao.BrandDao
import com.example.lab3.model.BrandData
import com.example.lab3.dao.ModelDao
import com.example.lab3.model.ModelData

@Database(
    entities = [
        BrandData::class,
        ModelData::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun brandDao(): BrandDao
    abstract fun modelDao(): ModelDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    DataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}