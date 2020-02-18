package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesRepository @Inject constructor(private val sharedPreferences: SharedPreferences) :
    PreferencesDataSource