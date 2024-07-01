package com.bhavanshu.dalwadi.fungallery.models

import com.google.gson.annotations.SerializedName

data class Album (
    @SerializedName(value = "userId", alternate = ["user_id", "userid"])
    val userId: Int,
    val id: Int,
    val title: String
)