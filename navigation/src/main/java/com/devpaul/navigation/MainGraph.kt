package com.devpaul.navigation

import kotlinx.serialization.Serializable

class MainGraph {

    @Serializable
    object DialogFragment

    @Serializable
    object AuthFragment

    @Serializable
    data class AuthArgs(val userId: String, val token: String)
}