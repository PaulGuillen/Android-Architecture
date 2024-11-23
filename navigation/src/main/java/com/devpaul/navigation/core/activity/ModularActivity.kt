package com.telefonica.navigation.core.activity

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.telefonica.navigation.core.ModularDestination
import com.telefonica.navigation.core.ModularGraphBuilder
import com.telefonica.navigation.core.navController
import com.telefonica.navigation.core.modularGraph
import com.telefonica.navigation.R

abstract class ModularActivity(
    @IdRes val navHostFragmentId: Int
): AppCompatActivity() {

    private val navController by navController(navHostFragmentId)

    fun modularGraph(
        startDestination: ModularDestination,
        builder: ModularGraphBuilder.() -> Unit
    ) {
        navController.modularGraph(
            startDestination = startDestination,
            builder = builder,
        )
    }
}