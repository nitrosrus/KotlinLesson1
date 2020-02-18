package com.example.kotlinlesson1

import android.app.Application
import com.example.kotlinlesson1.di.appModule
import com.example.kotlinlesson1.di.mainModule
import com.example.kotlinlesson1.di.noteModule
import com.example.kotlinlesson1.di.splashModule
import org.koin.android.ext.android.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin (this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}