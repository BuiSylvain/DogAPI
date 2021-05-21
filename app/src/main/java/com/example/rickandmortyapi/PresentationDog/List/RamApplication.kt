package com.example.rickandmortyapi.PresentationDog.List

import android.app.Application
import android.content.Context

class RamApplication : Application() {

    companion object {
        var context: Context?= null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}