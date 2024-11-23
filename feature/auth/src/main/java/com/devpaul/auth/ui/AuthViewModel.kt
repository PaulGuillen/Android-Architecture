package com.devpaul.auth.ui

import android.os.Handler
import android.os.Looper
import com.devpaul.core_platform.lifecycle.StatefulViewModel
import kotlinx.coroutines.delay
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel : StatefulViewModel<AuthUiState, AuthUiIntent, AuthUiEvent>(
defaultUIState = {
    AuthUiState()
}
){
    init {
        isLoading = true
        Handler(Looper.getMainLooper()).postDelayed({
            isLoading = false
        }, 3000)

    }

    override suspend fun onUiIntent(intent: AuthUiIntent) {

    }
}