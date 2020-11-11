package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleFragmentFactory(): ArticleFragment
}