package com.devpaul.android_architecture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.devpaul.auth.AuthNavigationCompose
import com.devpaul.auth.AuthNavigationCompose.addAuthGraph

@Composable
fun ComposeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthNavigationCompose.route
    ) {
        addAuthGraph(navController)
    }
}