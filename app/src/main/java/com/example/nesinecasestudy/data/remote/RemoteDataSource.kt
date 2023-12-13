package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.domain.model.PostModel
import io.reactivex.Observable

interface RemoteDataSource {

    fun getPosts(): Observable<List<PostModel>>
}