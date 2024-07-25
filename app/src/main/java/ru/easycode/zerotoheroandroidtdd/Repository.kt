package ru.easycode.zerotoheroandroidtdd

import java.io.IOException
import java.net.UnknownHostException

interface Repository {

    suspend fun load(): LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): LoadResult {
            return try {
                LoadResult.Success(service.fetch(url))
            } catch (ex: IllegalStateException) {
                LoadResult.Error(noConnection = false)
            } catch (ex: UnknownHostException) {
                LoadResult.Error(noConnection = true)
            }
        }
    }
}
