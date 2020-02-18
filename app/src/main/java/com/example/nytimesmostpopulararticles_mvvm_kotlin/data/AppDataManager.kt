package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.DbRepository
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs.PreferencesRepository
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val apiRepository: ApiRepository,
    private val dbRepository: DbRepository,
    private val preferencesRepository: PreferencesRepository
) : DataManager {
    fun getApiRepository(): ApiRepository {
        return apiRepository
    }

    fun getDbRepository(): DbRepository {
        return dbRepository
    }

    fun getPreferencesRepository(): PreferencesRepository {
        return preferencesRepository
    }
}
