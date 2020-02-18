package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.network.ApiService
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.ApiInfo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiService: ApiService, @param:ApiInfo private val apiKey: String) :
    ApiDataSource {
    override fun getArticles(period: Int): Single<ArticlesResponse> {
        return apiService.getArticles(period, apiKey)
    }

}