package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local

import android.content.Context
import androidx.room.Room
import com.example.nytimesmostpopulararticles_mvvm_kotlin.utils.AppConstants

object Database {
    object Companion {
        fun appDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}