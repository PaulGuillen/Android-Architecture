package com.devpaul.util

import com.devpaul.navigation.MainGraph
import com.devpaul.navigation.core.ModularGraphBuilder
import com.devpaul.navigation.core.fragment
import com.devpaul.util.ui.DialogFragment

fun ModularGraphBuilder.utilNavigation() {
    fragment<DialogFragment, MainGraph.DialogFragment>()
}