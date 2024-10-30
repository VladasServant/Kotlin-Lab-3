package com.example.lab3

object DataSource {
    fun getItemData(): List<NewData> {
        return listOf(
            NewData("Apple", "iPhone 16", "2024"),
            NewData("Samsung", "Galaxy S24", "2024"),
            NewData("Google", "Pixel 9 Pro", "2024"),
            NewData("OnePlus", "OnePlus 9T", "2022"),
            NewData("Xiaomi", "Mi 12", "2022"),
            NewData("Sony", "Xperia 5 III", "2021"),
            NewData("Huawei", "P40 Pro", "2020"),
            NewData("Motorola", "Moto G Power", "2020"),
            NewData("Nokia", "Nokia 8.3", "2020"),
            NewData("LG", "Wing", "2020")
        )
    }
}