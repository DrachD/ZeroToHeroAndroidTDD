package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface UiState {
    object ShowProgress : UiState
    object ShowData : UiState
}

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper = LiveDataWrapper.Base(),
    private val repository: Repository = Repository.Base()
) : ViewModel() {
    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        liveDataWrapper.update(UiState.ShowData)

        CoroutineScope(Dispatchers.Main).launch {
            repository.load()
        }
    }
}