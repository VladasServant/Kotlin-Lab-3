package com.example.lab3

import android.app.Application
import com.example.lab3.database.DataBase
import com.example.lab3.repo.Repo

class MainApp: Application() {
    private val database by lazy { DataBase.getDatabase(this) }
    val appRepo by lazy { Repo(database.modelDao(), database.brandDao()) }
}