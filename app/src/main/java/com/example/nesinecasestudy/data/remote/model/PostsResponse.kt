package com.example.nesinecasestudy.data.remote.model

import androidx.annotation.Keep

@Keep
data class PostResponse(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val imageUrl: String?
)