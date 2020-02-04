package com.example.nytimesmostpopulararticles_mvvm_kotlin.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.db.DbHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.local.prefs.PreferencesHelper
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api.ArticlesResponse
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db.Article
import com.example.nytimesmostpopulararticles_mvvm_kotlin.data.remote.ApiHelper
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val mContext: Context,
    private val mDbHelper: DbHelper,
    private val mPreferencesHelper: PreferencesHelper,
    private val mApiHelper: ApiHelper,
    private val mGson: Gson
) : DataManager {
    override fun getArticlesApiCall(period: Int): Single<ArticlesResponse?>? {
        return mApiHelper.getArticlesApiCall(period)
    }

    override fun insertArticle(article: Article?): Observable<Boolean?>? {
        return mDbHelper.insertArticle(article)
    }

    override fun deleteArticle(article: Article?): Observable<Boolean?>? {
        return mDbHelper.deleteArticle(article)
    }

    override fun findById(id: Long?): Observable<Article?>? {
        return mDbHelper.findById(id)
    }

    override val allArticles: LiveData<List<Article?>?>?
        get() = mDbHelper.allArticles

    companion object {
        private const val TAG = "AppDataManager"
    }

}