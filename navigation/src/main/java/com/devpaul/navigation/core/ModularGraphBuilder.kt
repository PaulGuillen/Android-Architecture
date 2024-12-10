package com.devpaul.navigation.core

import androidx.compose.runtime.Composable
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import kotlin.reflect.KClass

interface ModularGraphBuilder {

    fun createFragment(
        destination: ModularDestination,
        fragment: KClass<out Fragment>,
    )

//    fun createComposable(
//        destination: ModularDestination,
//        content: @Composable (NavBackStackEntry) -> Unit
//    )

    fun createDialog(
        destination: ModularDestination,
        dialog: KClass<out DialogFragment>,
    )

    fun createNavigation(
        startDestination: ModularDestination,
        route: ModularDestination,
        builder: ModularGraphBuilder.() -> Unit,
    )

    fun build(): NavGraph
}