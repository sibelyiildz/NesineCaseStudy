package com.example.nesinecasestudy.util

sealed class UIState<out R> {

    data class Success<out T>(val data: T? = null) : UIState<T>()

    data class Error(val error: Throwable) : UIState<Nothing>()

    object Loading : UIState<Nothing>()
}
