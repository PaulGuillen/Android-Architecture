package com.telefonica.core_platform.activity

import android.view.View
import androidx.annotation.IdRes
import com.telefonica.navigation.core.activity.ModularActivity

abstract class AppActivity(
    @IdRes navHostFragmentId: Int
): ModularActivity(navHostFragmentId) {

    abstract fun fragmentContainer(): View
}