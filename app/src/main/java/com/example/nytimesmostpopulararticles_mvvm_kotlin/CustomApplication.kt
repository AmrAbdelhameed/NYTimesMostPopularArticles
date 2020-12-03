package com.example.nytimesmostpopulararticles_mvvm_kotlin

import android.app.Application
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleDetailsDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.ArticleFavoritesDataSource
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.Database
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.Api
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository.ArticleDetailsRepository
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository.ArticleFavoritesRepository
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.repository.ArticleRepository
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article_details.ArticleDetailsViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites.FavoritesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule = module {
            single { Api.Companion.apiService() }
            single { Database.Companion.appDatabase(get()) }

            viewModel { ArticleViewModel(get() as ArticleDataSource) }
            viewModel { ArticleDetailsViewModel(get() as ArticleDetailsDataSource) }
            viewModel { FavoritesViewModel(get() as ArticleFavoritesDataSource) }

            single<ArticleDataSource> { ArticleRepository(get()) }
            single<ArticleDetailsDataSource> { ArticleDetailsRepository(get()) }
            single<ArticleFavoritesDataSource> { ArticleFavoritesRepository(get()) }
        }
        startKoin {
            androidContext(this@CustomApplication)
            modules(listOf(myModule))
        }
    }
}