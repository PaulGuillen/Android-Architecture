package com.devpaul.android_architecture

import com.devpaul.auth.AuthModule
import com.devpaul.util.UtilModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    [
        AuthModule::class,
        UtilModule::class,
    ]
)

@ComponentScan
class AppModule