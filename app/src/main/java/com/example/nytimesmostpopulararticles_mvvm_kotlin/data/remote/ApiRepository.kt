package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.network.ApiService
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.ApiInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiService: ApiService, @param:ApiInfo private val apiKey: String) :
    ApiDataSource {
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getArticles(period: Int): Result<ArticlesResponse> =
        withContext(ioDispatcher) {
            try {
                val articlesResponse = apiService.getArticles(period, apiKey)
                return@withContext Result.Success(articlesResponse)
            } catch (e: Exception) {
                return@withContext Result.Error(e.localizedMessage)
            }
        }

}