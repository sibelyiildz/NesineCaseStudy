package com.example.nesinecasestudy.data.remote.service

import com.example.nesinecasestudy.data.remote.model.PostResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getPosts(): Observable<List<PostResponse>>

}