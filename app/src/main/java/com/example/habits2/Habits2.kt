package com.example.habits2

import android.app.Application

class Habits2 : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}