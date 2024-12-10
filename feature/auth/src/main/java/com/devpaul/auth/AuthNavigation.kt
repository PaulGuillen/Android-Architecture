package com.devpaul.auth

import com.devpaul.auth.ui.AuthFragment
import com.devpaul.navigation.MainGraph
import com.devpaul.navigation.core.ModularGraphBuilder
import com.devpaul.navigation.core.fragment

fun ModularGraphBuilder.authNavigation() {
    fragment<AuthFragment, MainGraph.AuthFragment>()
//    compose<MainGraph.AuthArgs> { args ->
//        AuthScreen(args)
//    }
}
