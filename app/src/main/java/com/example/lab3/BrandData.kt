package com.example.lab3

data class BrandData(
    val brand: String,
    val foundedDate: String,
    val aboutCompany: String
) : ItemInterface {
    override fun getItemType(): Int {
        return ItemInterface.Brand
    }
}
