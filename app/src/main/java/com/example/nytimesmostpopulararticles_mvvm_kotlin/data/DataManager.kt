package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.DbHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs.PreferencesHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiHelper

interface DataManager : DbHelper, PreferencesHelper, ApiHelper 