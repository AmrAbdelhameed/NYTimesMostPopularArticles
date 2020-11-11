package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.dao.ArticleDao
import com.example.nytimesmostpopulararticles_mvvm_kotlin.domain.dto.db.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}