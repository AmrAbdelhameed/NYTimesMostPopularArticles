package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article)

    @Delete
    fun delete(article: Article)

    @Query("SELECT * FROM favorites WHERE id = :id")
    fun findById(id: Long): Article

    @Query("SELECT * FROM favorites")
    fun loadAll(): LiveData<List<Article>>
}