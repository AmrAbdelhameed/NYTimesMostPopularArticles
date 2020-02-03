package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main

import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider

class MainViewModel(dataManager: DataManager?, schedulerProvider: SchedulerProvider?) :
    BaseViewModel<Any?>(dataManager!!, schedulerProvider!!)