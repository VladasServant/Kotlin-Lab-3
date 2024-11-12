package com.example.lab3.database

import androidx.room.Database
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
}