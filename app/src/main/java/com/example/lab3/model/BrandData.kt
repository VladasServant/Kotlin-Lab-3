package com.example.lab3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "brands_table")
data class BrandData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var brand: String,
    var foundedDate: String,
    val aboutCompany: String
) : ItemInterface {

    override fun getItemType(): Int {
        return ItemInterface.Brand
    }
}