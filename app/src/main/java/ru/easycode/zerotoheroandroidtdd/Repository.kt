package ru.easycode.zerotoheroandroidtdd

interface Repository {

    suspend fun load()

    class Base : Repository {
        private var actualCalledTimes: Int = 0

        override suspend fun load() {
            actualCalledTimes++
        }
    }
}