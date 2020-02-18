package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import io.reactivex.Observable

interface DbDataSource {
    fun insertArticle(article: Article): Observable<Unit>
    fun deleteArticle(article: Article): Observable<Unit>
    fun findById(id: Long): Observable<Article>
    fun allArticles(): LiveData<List<Article>>
}