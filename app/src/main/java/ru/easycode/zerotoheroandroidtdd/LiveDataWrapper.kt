package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Update {
        fun update(value: UiState)
    }

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Mutable : LiveDataWrapper, Update, Save, LiveDataProvider

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData<UiState>()
    ) : Mutable {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let {
                bundleWrapper.save(it)
            }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}

interface LiveDataProvider {
    fun liveData(): LiveData<UiState>
}