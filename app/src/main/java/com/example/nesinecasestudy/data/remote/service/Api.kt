package com.example.nesinecasestudy.data.remote.service

import com.example.nesinecasestudy.data.remote.model.PostsResponse
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): PostsResponse

}