package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val liveDataWrapper = LiveDataWrapper.Base()
        val repository = Repository.Base()
        viewModel = MainViewModel(liveDataWrapper, repository)
    }
}