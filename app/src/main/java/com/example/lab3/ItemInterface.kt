package com.example.lab3

interface ItemInterface {
    fun getItemType(): Int

    companion object{
        const val Brand = 1
        const val Model = 2
    }
}