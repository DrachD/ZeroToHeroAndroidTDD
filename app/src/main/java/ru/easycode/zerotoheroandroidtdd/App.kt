package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val repository: Repository = Repository.Base()
        val liveDataWrapper: LiveDataWrapper = LiveDataWrapper.Base()
        viewModel = MainViewModel(liveDataWrapper, repository)
    }
}