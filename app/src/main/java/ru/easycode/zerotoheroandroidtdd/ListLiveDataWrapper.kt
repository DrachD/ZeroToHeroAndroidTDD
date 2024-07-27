package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import kotlin.collections.ArrayList

interface ListLiveDataWrapper : LiveDataProvider {

    fun add(new: CharSequence)

    fun save(bundle: BundleWrapper.Save)

    fun update(list: List<CharSequence>)

    class Base(
        private val liveData: MutableLiveData<ArrayList<CharSequence>> = MutableLiveData()
    ) : ListLiveDataWrapper {
        override fun add(new: CharSequence) {
            val currentList = liveData.value ?: ArrayList()
            currentList.add(new)

            update(currentList)
        }

        override fun save(bundle: BundleWrapper.Save) {
            liveData.value?.let {
                bundle.save(ArrayList(it))
            }
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = ArrayList(list)
        }

        override fun liveData(): LiveData<List<CharSequence>> = liveData.map { it.toList() }
    }
}

interface LiveDataProvider {
    fun liveData(): LiveData<List<CharSequence>>
}