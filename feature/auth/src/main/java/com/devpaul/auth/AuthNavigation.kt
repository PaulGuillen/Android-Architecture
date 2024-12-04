package com.devpaul.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.devpaul.auth.ui.AuthFragment
import com.devpaul.navigation.MainGraph
import com.devpaul.navigation.core.ModularGraphBuilder
import com.devpaul.navigation.core.compose.Screen
import com.devpaul.navigation.core.fragment

fun ModularGraphBuilder.authNavigation() {
    fragment<AuthFragment, MainGraph.AuthFragment>()
}

object  AuthNavigationCompose {
    const val route = "auth"

    fun NavGraphBuilder.addAuthGraph(navController: NavHostController) {
        composable(Screen.Auth.route) {
            AuthScreen(navController = navController)
        }
    }
}
