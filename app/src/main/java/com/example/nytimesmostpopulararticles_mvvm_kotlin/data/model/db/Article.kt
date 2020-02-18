package com.example.nytimesmostpopulararticles_mvvm_kotlin.data.model.db

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeString(byline)
        parcel.writeString(abstractX)
        parcel.writeString(publishedDate)
        parcel.writeString(url)
        parcel.writeString(coverImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}