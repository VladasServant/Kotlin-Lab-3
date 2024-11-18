package com.example.lab3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity (tableName = "brands_table")
data class BrandData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @field:Json(name = "brand") val brand: String,
    @field:Json(name = "foundedDate") val foundedDate: String,
    @field:Json(name = "aboutCompany") val aboutCompany: String
) : ItemInterface {

    override fun getItemType(): Int {
        return ItemInterface.Brand
    }
}