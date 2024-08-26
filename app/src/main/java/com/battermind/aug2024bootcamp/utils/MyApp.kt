package com.battermind.aug2024bootcamp.utils

import android.app.Application
import com.battermind.aug2024bootcamp.database.BetterMindDatabase

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val database = BetterMindDatabase.getDataBase(this)
    }
}