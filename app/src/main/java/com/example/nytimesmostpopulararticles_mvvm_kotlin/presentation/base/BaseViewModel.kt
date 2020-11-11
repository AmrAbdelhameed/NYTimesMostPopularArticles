package com.example.nytimesmostpopulararticles_mvvm_kotlin.presentation.base

import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val isLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
}