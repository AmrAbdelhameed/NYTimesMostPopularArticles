package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(private val mAppDatabase: AppDatabase) : DbDataSource {

    override suspend fun insertArticle(article: Article) = mAppDatabase.articleDao().insert(article)
    override suspend fun deleteArticle(article: Article) = mAppDatabase.articleDao().delete(article)
    override suspend fun findById(id: Long): Result<Article> {
        return try {
            val article = mAppDatabase.articleDao().findById(id)
            Result.Success(article)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }

    override fun allArticles(): LiveData<List<Article>> = mAppDatabase.articleDao().loadAll()
}