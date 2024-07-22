package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base : LiveDataWrapper {
        private val actualCallsList = mutableListOf<UiState>()
        override fun update(value: UiState) {
            actualCallsList.add(value)
        }

        override fun liveData(): LiveData<UiState> {
            throw IllegalStateException("not used in test")
        }
    }
}