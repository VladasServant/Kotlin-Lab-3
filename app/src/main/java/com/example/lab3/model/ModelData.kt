package com.example.lab3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (
    tableName = "models_table",
    foreignKeys = [
        ForeignKey(
            entity = BrandData::class,
            parentColumns = ["id"],
            childColumns = ["idBrand"],
            onDelete = ForeignKey.CASCADE
        )
    ], indices = [Index(value = ["idBrand"])]
)
data class ModelData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var modelName: String,
    val releaseYear: String,
    val idBrand: Int
) : ItemInterface {


    override fun getItemType(): Int {
        return ItemInterface.Model
    }
}