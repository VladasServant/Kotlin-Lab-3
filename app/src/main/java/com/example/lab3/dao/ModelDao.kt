package com.example.lab3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab3.model.ModelData

@Dao
interface ModelDao {
    @Insert
    suspend fun insertModel(model: ModelData)

    @Insert
    suspend fun insertModels(models: List<ModelData>)

    @Update
    suspend fun updateModel(model: ModelData)

    @Query("SELECT * FROM models_table")
    suspend fun getAllModels(): List<ModelData>

    @Delete
    suspend fun deleteModel(model: ModelData)

    @Query("DELETE FROM models_table")
    suspend fun clearModels()
}