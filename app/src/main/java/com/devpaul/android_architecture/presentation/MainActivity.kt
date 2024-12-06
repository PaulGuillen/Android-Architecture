package com.devpaul.android_architecture.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
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
        get() = loadingAnimation().isVisible
        set(value) {
            loadingAnimation().isVisible = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()
        setupNavigation()
        Glide.with(this).load(com.devpaul.core_platform.R.drawable.gif_loading_green).into(binding.loadingContainer.ivLoading)
//        enableEdgeToEdge()
//        setContent {
//            Surface(color = MaterialTheme.colorScheme.background) {
//                val navController = rememberNavController()
//                ComposeNavGraph(navController)
//            }
//        }
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

    private fun progressBar() = binding.toolBarContainer.progress

    private fun loadingAnimation() = binding.linearLoading

    override fun fragmentContainer() = binding.mainContent
}
