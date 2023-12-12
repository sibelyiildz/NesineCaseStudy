package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.data.remote.service.Api
import io.reactivex.Observable

class RemoteDataSourceImp(private val api: Api) : RemoteDataSource {

    override fun getPosts(): Observable<List<PostResponse>> {
        return api.getPosts()
    }

}