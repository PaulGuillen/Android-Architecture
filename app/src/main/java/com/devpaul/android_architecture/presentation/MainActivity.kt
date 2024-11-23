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
import timber.log.Timber

class MainActivity : AppActivity(
    navHostFragmentId = R.id.main_content
), LoadingActivity, ActivityScaffold {

    // ViewBinding para la actividad principal
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Indicador de carga
    override var isLoading: Boolean
        get() = progressBar().isVisible
        set(value) {
            progressBar().isVisible = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()
        setupNavigation()
    }

    // Configuración inicial de la Toolbar
    private fun setupToolbar() {
        setSupportActionBar(binding.toolBarContainer.toolbar)
    }

    // Actualiza el estado de la Toolbar basado en el ToolbarMode
    override fun setToolbarMode(toolbarMode: ToolbarMode) {
        when (toolbarMode) {
            ToolbarMode.Hide -> hideToolbar()
            is ToolbarMode.Visible -> showToolbar(toolbarMode)
            ToolbarMode.Default -> resetToolbar()
            ToolbarMode.None -> Unit
        }
    }

    // Oculta la Toolbar
    private fun hideToolbar() {
        binding.toolBarContainer.toolbar.isVisible = false
    }

    // Muestra y configura la Toolbar
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

    // Restablece la Toolbar al estado por defecto
    private fun resetToolbar() {
        binding.toolBarContainer.toolbar.apply {
            isVisible = true
            title = ""
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    // Obtiene la barra de progreso
    private fun progressBar() = binding.toolBarContainer.progress

    // Contenedor para fragmentos
    override fun fragmentContainer() = binding.mainContent
}
