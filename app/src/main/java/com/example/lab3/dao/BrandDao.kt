package com.example.lab3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab3.model.BrandData

@Dao
interface BrandDao {
    @Insert
    suspend fun insertBrand(brand: BrandData)

    @Insert
    suspend fun insertBrands(brands: List<BrandData>)

    @Update
    suspend fun updateBrand(brand: BrandData)

    @Query("SELECT * FROM brands_table")
    suspend fun getAllBrands(): List<BrandData>

    @Delete
    suspend fun deleteBrand(brand: BrandData)

    @Query("DELETE FROM brands_table")
    suspend fun clearBrands()
}