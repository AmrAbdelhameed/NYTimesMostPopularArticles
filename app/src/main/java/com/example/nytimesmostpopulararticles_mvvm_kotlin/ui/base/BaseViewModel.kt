package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.SingleLiveEvent

abstract class BaseViewModel(
    val application: Application,
    val appDataManager: AppDataManager
) : ViewModel() {
    val isLoading = ObservableBoolean()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()

    fun setIsLoading(b: Boolean) {
        isLoading.set(b)
    }
}