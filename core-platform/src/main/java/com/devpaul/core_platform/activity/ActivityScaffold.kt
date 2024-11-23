package com.telefonica.core_platform.activity

import com.telefonica.core_platform.entity.BottomNavMode
import com.telefonica.core_platform.entity.ToolbarMode

interface ActivityScaffold {

    fun setToolbarMode(toolbarMode: ToolbarMode) {}

    fun setBottomNavMode(bottomNavMode: BottomNavMode) {}
}