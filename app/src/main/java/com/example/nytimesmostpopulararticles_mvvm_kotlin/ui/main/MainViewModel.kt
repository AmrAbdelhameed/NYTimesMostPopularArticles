package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main

import android.app.Application
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel

class MainViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel(application, appDataManager)