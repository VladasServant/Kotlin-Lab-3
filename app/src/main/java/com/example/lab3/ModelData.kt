package com.example.lab3

data class ModelData(
    val modelName: String,
    val releaseYear: String,
) : ItemInterface {
    override fun getItemType(): Int {
        return ItemInterface.Model
    }
}
