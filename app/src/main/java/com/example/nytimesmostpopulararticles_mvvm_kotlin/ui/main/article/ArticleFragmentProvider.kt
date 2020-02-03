package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector(modules = [ArticleFragmentModule::class])
    abstract fun provideArticleFragmentFactory(): ArticleFragment?
}