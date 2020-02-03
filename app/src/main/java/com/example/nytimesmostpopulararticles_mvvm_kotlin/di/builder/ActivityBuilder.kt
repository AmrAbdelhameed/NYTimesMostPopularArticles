package com.example.nytimesmostpopulararticles_mvvm_kotlin.di.builder

import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainActivity
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.MainActivityModule
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article.ArticleFragmentProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article_details.ArticleDetailsFragmentProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.favorites.FavoritesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class, ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class, FavoritesFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity?
}