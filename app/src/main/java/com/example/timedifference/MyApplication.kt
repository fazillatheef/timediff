package com.example.timedifference


import android.app.Application

class MyApplication : Application() {
    companion object {
        var g_hour_start = 0
        var g_min_start = 0
        var g_hour_end = 0
        var g_min_end = 0
    }
    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}