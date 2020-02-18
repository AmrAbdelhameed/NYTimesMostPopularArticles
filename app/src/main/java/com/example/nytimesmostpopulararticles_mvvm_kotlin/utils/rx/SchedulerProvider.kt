package com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}