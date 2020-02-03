package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.api

import com.google.gson.annotations.SerializedName

class ArticlesResponse {
    @SerializedName("results")
    var articles: List<Article>? = null

    class Article {
        var id: Long = 0
        var url: String? = null
        var byline: String? = null
        var type: String? = null
        var title: String? = null
        @SerializedName("abstract")
        var abstractX: String? = null
        var published_date: String? = null
        var media: List<MediaBean>? = null

        class MediaBean {
            @SerializedName("media-metadata")
            var mediametadata: List<MediametadataBean>? = null

            class MediametadataBean {
                var url: String? = null
            }
        }
    }
}