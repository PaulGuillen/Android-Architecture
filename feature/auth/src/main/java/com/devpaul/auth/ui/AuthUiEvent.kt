package com.devpaul.auth.ui

sealed class AuthUiEvent {
    data object LoadingStarted : AuthUiEvent()
    data object LoadingFinished : AuthUiEvent()
}