package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val listLiveDataWrapper: ListLiveDataWrapper = ListLiveDataWrapper.Base()
        viewModel = MainViewModel(listLiveDataWrapper)
    }
}