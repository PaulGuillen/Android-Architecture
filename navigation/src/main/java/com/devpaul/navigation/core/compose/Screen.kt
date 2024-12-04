package com.devpaul.navigation.core.compose

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Login : Screen("login")
    object Register : Screen("register")
}
