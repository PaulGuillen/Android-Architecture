package com.devpaul.android_architecture.navigation

import com.devpaul.auth.authNavigation
import com.devpaul.navigation.MainGraph
import com.devpaul.navigation.core.activity.ModularActivity
import com.devpaul.navigation.core.destinationOf

fun ModularActivity.setupNavigation() = modularGraph(
    startDestination = destinationOf<MainGraph.AuthFragment>(),
) {
    authNavigation()
}