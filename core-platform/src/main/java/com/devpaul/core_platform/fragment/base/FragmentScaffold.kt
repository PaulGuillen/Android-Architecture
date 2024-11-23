package com.telefonica.core_platform.fragment.base

import com.telefonica.core_platform.entity.BottomNavMode
import com.telefonica.core_platform.entity.ToolbarMode

interface FragmentScaffold {

    fun toolbarMode(): ToolbarMode = ToolbarMode.None

    fun bottomNavMode(): BottomNavMode = BottomNavMode.None
}