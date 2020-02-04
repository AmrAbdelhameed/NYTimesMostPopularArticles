package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.DataManager
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager?,
    val schedulerProvider: SchedulerProvider?
) : ViewModel() {
    val isLoading = ObservableBoolean()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var mNavigator: WeakReference<N>? = null
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(b: Boolean) {
        isLoading.set(b)
    }

    val navigator: N?
        get() = mNavigator?.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

}