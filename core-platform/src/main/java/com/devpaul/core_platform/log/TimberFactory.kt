package com.devpaul.core_platform.log

import com.devpaul.navigation.BuildConfig
import timber.log.Timber

object TimberFactory {

    fun setup() {
        Timber.uprootAll()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}