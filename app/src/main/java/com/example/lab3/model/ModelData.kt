package com.example.lab3.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

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
    @field:Json(name = "modelName") val modelName: String,
    @field:Json(name = "releaseYear") val releaseYear: String,
    @field:Json(name = "idBrand") val idBrand: Int
) : ItemInterface {


    override fun getItemType(): Int {
        return ItemInterface.Model
    }
}