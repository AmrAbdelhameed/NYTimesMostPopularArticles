package com.example.nytimesmostpopulararticles_mvvm_kotlin.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.AppDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.network.ApiService
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.ApiInfo
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)
    }
}