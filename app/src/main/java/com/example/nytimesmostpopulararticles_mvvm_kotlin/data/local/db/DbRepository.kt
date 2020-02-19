package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.Result
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(private val mAppDatabase: AppDatabase) : DbDataSource {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun insertArticle(article: Article) {
        withContext(ioDispatcher) {
            mAppDatabase.articleDao().insert(article)
        }
    }

    override suspend fun deleteArticle(article: Article) {
        withContext(ioDispatcher) {
            mAppDatabase.articleDao().delete(article)
        }
    }

    override suspend fun findById(id: Long): Result<Article> = withContext(ioDispatcher) {
        try {
            val article = mAppDatabase.articleDao().findById(id)
            return@withContext Result.Success(article)
        } catch (e: Exception) {
            return@withContext Result.Error(e.localizedMessage)
        }
    }

    override fun allArticles(): LiveData<List<Article>> {
        return mAppDatabase.articleDao().loadAll()
    }

}