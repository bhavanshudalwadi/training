package com.bhavanshu.dalwadi.fungallery.models

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName(value = "albumId", alternate = ["album_id", "albumid"])
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    @SerializedName(value = "thumbnailUrl", alternate = ["thumbnail_url", "thumbnailurl"])
    val thumbnailUrl: String
)