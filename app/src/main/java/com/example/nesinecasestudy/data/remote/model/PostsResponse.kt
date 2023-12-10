package com.example.nesinecasestudy.data.remote.model

import androidx.annotation.Keep

@Keep
data class PostsResponse(
    val posts: List<Post>
)

@Keep
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)