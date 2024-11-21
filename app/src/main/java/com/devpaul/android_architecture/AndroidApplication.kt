package com.devpaul.android_architecture

import android.app.Application

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        timberInitializer()
    }

    private fun timberInitializer() {
       // TimberFactory.setup()
    }
}