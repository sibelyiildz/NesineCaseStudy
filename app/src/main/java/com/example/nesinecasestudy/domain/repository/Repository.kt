package com.example.nesinecasestudy.domain.repository

import com.example.nesinecasestudy.data.remote.model.PostResponse
import io.reactivex.Observable

interface Repository {

    fun getPosts(): Observable<List<PostResponse>>
}