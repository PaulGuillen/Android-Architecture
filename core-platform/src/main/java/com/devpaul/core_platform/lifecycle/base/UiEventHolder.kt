package com.telefonica.core_platform.lifecycle.base

interface UiEventHolder<UiEvent> {

    suspend fun setOnUiEvent(onEvent: suspend (UiEvent) -> Unit)

    fun UiEvent.send()

}