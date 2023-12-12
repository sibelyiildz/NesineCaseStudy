package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.data.remote.model.PostResponse
import io.reactivex.Observable

interface RemoteDataSource {

    fun getPosts(): Observable<List<PostResponse>>
}