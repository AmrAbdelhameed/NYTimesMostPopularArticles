package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import io.reactivex.Observable

interface DbHelper {
    fun insertArticle(article: Article?): Observable<Boolean?>?
    fun deleteArticle(article: Article?): Observable<Boolean?>?
    fun findById(id: Long): Observable<Article?>?
    val allArticles: LiveData<List<Article?>?>?
}