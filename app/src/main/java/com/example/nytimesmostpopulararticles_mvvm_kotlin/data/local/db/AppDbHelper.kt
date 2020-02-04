package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private val mAppDatabase: AppDatabase) : DbHelper {
    override fun insertArticle(article: Article?): Observable<Boolean?>? {
        return Observable.fromCallable {
            mAppDatabase.articleDao()?.insert(article)
            true
        }
    }

    override fun deleteArticle(article: Article?): Observable<Boolean?>? {
        return Observable.fromCallable {
            mAppDatabase.articleDao()?.delete(article)
            true
        }
    }

    override fun findById(id: Long?): Observable<Article?>? {
        return Observable.fromCallable { id?.let { mAppDatabase.articleDao()?.findById(it) } }
    }

    override val allArticles: LiveData<List<Article?>?>?
        get() = mAppDatabase.articleDao()?.loadAll()

}