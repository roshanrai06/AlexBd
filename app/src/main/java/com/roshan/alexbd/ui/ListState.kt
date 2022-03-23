package com.roshan.alexbd.ui


sealed class ListState {
    object Loading : ListState()
    object Empty : ListState()
    object Loaded : ListState()
    class Error(val string: String) : ListState()

}