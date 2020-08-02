package com.example.nytimesmostpopulararticles_mvvm_kotlin.di.component

import android.app.Application
import com.example.nytimesmostpopulararticles_mvvm_kotlin.CustomApplication
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.builder.ActivityBuilder
import com.example.nytimesmostpopulararticles_mvvm_kotlin.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    fun inject(app: CustomApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}