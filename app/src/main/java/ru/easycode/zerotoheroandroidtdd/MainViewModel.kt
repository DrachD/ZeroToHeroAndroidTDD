package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

class MainViewModel(
    private val listLiveDataWrapper: ListLiveDataWrapper
) : LiveDataProvider {
    fun add(text: CharSequence) {
        listLiveDataWrapper.add(text)
    }

    fun save(bundle: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundle)
    }

    fun restore(bundle: BundleWrapper.Restore) {
        listLiveDataWrapper.update(bundle.restore())
    }

    override fun liveData(): LiveData<List<CharSequence>> = listLiveDataWrapper.liveData()
}