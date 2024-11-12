package com.example.lab3.model

interface ItemInterface {
    fun getItemType(): Int

    companion object{
        const val Brand = 1
        const val Model = 2
    }
}