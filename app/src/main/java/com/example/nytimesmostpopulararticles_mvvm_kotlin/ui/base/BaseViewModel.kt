package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.AppDataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<N>(
    val application: Application,
    val appDataManager: AppDataManager
) : ViewModel(), CoroutineScope {
    val isLoading = ObservableBoolean()
    private var mNavigator: WeakReference<N>? = null

    private val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job // By default child coroutines will run on the main thread.

    override fun onCleared() {
        super.onCleared()
        job.cancel() // Parent Job cancels all child coroutines.
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