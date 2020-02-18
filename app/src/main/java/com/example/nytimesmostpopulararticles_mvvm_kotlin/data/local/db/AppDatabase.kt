package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.dao.ArticleDao
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}