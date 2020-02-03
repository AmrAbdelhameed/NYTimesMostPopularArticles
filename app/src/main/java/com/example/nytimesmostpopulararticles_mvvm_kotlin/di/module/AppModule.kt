package com.example.nytimesmostpopulararticles_mvvm_kotlin.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.nytimesmostpopulararticles_mvvm_kotlin.BuildConfig
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.AppDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.AppDbHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.DbHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs.AppPreferencesHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs.PreferencesHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.AppApiHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.ApiInfo
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.DatabaseInfo
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.PreferenceInfo
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.AppSchedulerProvider
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String?, context: Context?): AppDatabase {
        return Room.databaseBuilder(context!!, AppDatabase::class.java, dbName!!)
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}