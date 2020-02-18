package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class MainViewModel(appDataManager: AppDataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<Any>(appDataManager, schedulerProvider)