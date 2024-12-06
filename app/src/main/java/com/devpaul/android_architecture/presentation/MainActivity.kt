package com.devpaul.android_architecture.presentation

import android.graphics.Color
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
import com.devpaul.core_platform.ui.LoadingFragment

class MainActivity : AppActivity(
    navHostFragmentId = R.id.main_content
), LoadingActivity, ActivityScaffold {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override var isLoading: Boolean
        get() = supportFragmentManager.findFragmentByTag(LOADING_FRAGMENT) != null
        set(value) {
            if (value) {
                showLoadingFragment()
            } else {
                hideLoadingFragment()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()
        setupNavigation()
    }

    private fun showLoadingFragment() {
        if (supportFragmentManager.findFragmentByTag(LOADING_FRAGMENT) == null) {
            val loadingFragment = LoadingFragment()
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, loadingFragment, LOADING_FRAGMENT)
                .commitAllowingStateLoss()
        }
    }

    private fun hideLoadingFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(LOADING_FRAGMENT)
        fragment?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commitAllowingStateLoss()
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolBarContainer.toolbar)
    }

    override fun setToolbarMode(toolbarMode: ToolbarMode) {
        when (toolbarMode) {
            ToolbarMode.Hide -> hideToolbar()
            is ToolbarMode.Visible -> showToolbar(toolbarMode)
            ToolbarMode.Default -> resetToolbar()
            ToolbarMode.None -> Unit
        }
    }

    private fun hideToolbar() {
        binding.toolBarContainer.toolbar.isVisible = false
    }

    private fun showToolbar(toolbarMode: ToolbarMode.Visible) {
        binding.toolBarContainer.toolbar.apply {
            isVisible = true
            setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            setTitleTextColor(Color.BLACK)
            setContentInsetsAbsolute(0, 0)
            contentInsetStartWithNavigation = 0
        }

        supportActionBar?.apply {
            title = toolbarMode.title
            setDisplayHomeAsUpEnabled(toolbarMode.allowBack)
            setHomeAsUpIndicator(com.devpaul.core_platform.R.drawable.baseline_arrow_back_24)
        }
    }

    private fun resetToolbar() {
        binding.toolBarContainer.toolbar.apply {
            isVisible = true
            title = ""
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun fragmentContainer() = binding.mainContent

    companion object {
        private const val LOADING_FRAGMENT = "LoadingFragment"
    }
}
