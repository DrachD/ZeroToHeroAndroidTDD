package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

interface UiState {

    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            textView.visibility = View.GONE
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            textView.visibility = View.VISIBLE
            button.isEnabled = true
            progressBar.visibility = View.GONE
        }
    }
}

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) : ProvideLiveData {


    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load() = viewModelScope.launch {
        liveDataWrapper.update(UiState.ShowProgress)
        repository.load()
        liveDataWrapper.update(UiState.ShowData)
    }

    override fun liveData(): LiveData<UiState> {
        return liveDataWrapper.liveData()
    }
}