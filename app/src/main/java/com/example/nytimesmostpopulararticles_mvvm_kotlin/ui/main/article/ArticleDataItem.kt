package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.main.article

import android.os.Parcel
import android.os.Parcelable

class ArticleDataItem(
    val id: Long,
    val imageUrl: String?,
    val title: String?,
    val byline: String?,
    val abstractX: String?,
    val publishedDate: String?,
    val url: String?,
    val coverImageUrl: String?
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

    companion object CREATOR : Parcelable.Creator<ArticleDataItem> {
        override fun createFromParcel(parcel: Parcel): ArticleDataItem {
            return ArticleDataItem(parcel)
        }

        override fun newArray(size: Int): Array<ArticleDataItem?> {
            return arrayOfNulls(size)
        }
    }
}