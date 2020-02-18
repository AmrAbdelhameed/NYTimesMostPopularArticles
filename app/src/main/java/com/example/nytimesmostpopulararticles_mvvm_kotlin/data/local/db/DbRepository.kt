package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(private val mAppDatabase: AppDatabase) : DbDataSource {
    override fun insertArticle(article: Article): Observable<Unit> {
        return Observable.fromCallable { mAppDatabase.articleDao().insert(article) }
    }

    override fun deleteArticle(article: Article): Observable<Unit> {
        return Observable.fromCallable { mAppDatabase.articleDao().delete(article) }
    }

    override fun findById(id: Long): Observable<Article> {
        return Observable.fromCallable { mAppDatabase.articleDao().findById(id) }
    }

    override fun allArticles(): LiveData<List<Article>> {
        return mAppDatabase.articleDao().loadAll()
    }

}