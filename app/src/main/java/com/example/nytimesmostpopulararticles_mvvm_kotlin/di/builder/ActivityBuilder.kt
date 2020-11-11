package com.example.nytimesmostpopulararticles_mvvm_kotlin.di.builder

import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.MainActivity
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article.ArticleFragmentProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article_details.ArticleDetailsFragmentProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.favorites.FavoritesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class, FavoritesFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}