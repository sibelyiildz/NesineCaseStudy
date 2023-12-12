package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.domain.model.PostUIModel
import io.reactivex.Observable

interface RemoteDataSource {

    fun getPosts(): Observable<List<PostUIModel>>
}