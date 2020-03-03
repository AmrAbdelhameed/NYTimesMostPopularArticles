package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class Article(
    @field:PrimaryKey val id: Long,
    @field:ColumnInfo(name = "image_url") val imageUrl: String?,
    val title: String?,
    val byline: String?,
    @field:ColumnInfo(name = "abstract") val abstractX: String?,
    @field:ColumnInfo(name = "published_date") val publishedDate: String?,
    val url: String?,
    @field:ColumnInfo(name = "cover_image_url") val coverImageUrl: String?
)