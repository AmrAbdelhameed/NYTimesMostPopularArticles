package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.main.article_details

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleDetailsFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleDetailsFragmentFactory(): ArticleDetailsFragment
}