package com.devpaul.core_platform.lifecycle

import androidx.lifecycle.ViewModel
import com.devpaul.core_domain.Defaults
import com.devpaul.core_platform.lifecycle.base.UiEventHolder
import com.devpaul.core_platform.lifecycle.base.UiIntentHolder
import com.devpaul.core_platform.lifecycle.base.ViewModelLoadable
import com.devpaul.core_domain.Output
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import timber.log.Timber

abstract class StatelessViewModel<UiIntent, UiEvent> : ViewModel(), UiEventHolder<UiEvent>,
    UiIntentHolder<UiIntent>, ViewModelLoadable {

    private val uiEventChannel = Channel<UiEvent>(Channel.BUFFERED)
    private val uiIntentChannel = Channel<UiIntent>(Channel.BUFFERED)
    private val defaultsChannel = Channel<Defaults<Nothing>>(Channel.BUFFERED)
    private val _isLoading = MutableStateFlow(false)
    override var isLoading: Boolean
        get() = _isLoading.value
        set(value) {
            _isLoading.tryEmit(value)
            Timber.d("isLoading - value: $value")
        }

    init {
        launch {
            uiIntentChannel.receiveAsFlow().collectLatest {
                onUiIntent(it)
            }
        }
    }

    override suspend fun setOnUiEvent(onEvent: suspend (UiEvent) -> Unit) {
        uiEventChannel.receiveAsFlow().collectLatest(onEvent)
    }

    suspend fun setOnDefaultError(onDefaultOutput: suspend (Defaults<Nothing>) -> Unit) {
        defaultsChannel.receiveAsFlow().collectLatest(onDefaultOutput)
    }

    final override fun UiEvent.send() {
        uiEventChannel.trySendBlocking(this)
    }

    override suspend fun onLoading(listener: (isLoading: Boolean) -> Unit) {
        _isLoading.collectLatest {
            Timber.d("isLoading - OnLoading: $it")
            listener(it)
        }
    }

    protected fun UiIntent.execute() {
        uiIntentChannel.trySendBlocking(this)
    }

    override fun executeUiIntent(intent: UiIntent) {
        uiIntentChannel.trySendBlocking(intent)
    }

    protected fun <I, E> Output<I, Defaults<E>>.handleNetworkDefault(): Output<I, Defaults<E>> {
        onFailure {
            when (it) {
                is Defaults.InactiveNetworkError -> defaultsChannel.trySendBlocking(it)
                is Defaults.TimeoutError -> defaultsChannel.trySendBlocking(it)
                is Defaults.ServerError -> defaultsChannel.trySendBlocking(it)
                is Defaults.UnknownError -> defaultsChannel.trySendBlocking(it)
                else -> Unit
            }
        }
        return this
    }
}