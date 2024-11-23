package com.devpaul.android_architecture.presentation

import android.content.Context
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.devpaul.android_architecture.R
import com.devpaul.android_architecture.databinding.ActivityMainBinding
import com.devpaul.android_architecture.navigation.setupNavigation
import com.devpaul.core_platform.activity.ActivityScaffold
import com.devpaul.core_platform.activity.AppActivity
import com.devpaul.core_platform.activity.LoadingActivity
import com.devpaul.core_platform.entity.ToolbarMode

class MainActivity : AppActivity(
    navHostFragmentId = R.id.main_content
), LoadingActivity, ActivityScaffold {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override var isLoading: Boolean
        get() = progressBar().isVisible
        set(value) {
            progressBar().isVisible = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarContainer.toolbar)
        setupNavigation()
    }

    override fun setToolbarMode(toolbarMode: ToolbarMode) {
        when (toolbarMode) {
            ToolbarMode.Hide -> {
                binding.toolBarContainer.toolbar.isVisible = false
            }

            is ToolbarMode.Visible -> {
                binding.toolBarContainer.toolbar.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            }

            ToolbarMode.Default -> {
                binding.toolBarContainer.toolbar.isVisible = true
                binding.toolBarContainer.toolbar.title = ""
            }

            ToolbarMode.None -> Unit
        }
    }

    private fun progressBar() = binding.toolBarContainer.progress

    override fun fragmentContainer() = binding.mainContent

}