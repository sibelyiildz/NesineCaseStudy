package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.data.remote.mapper.toPostModel
import com.example.nesinecasestudy.data.remote.service.Api
import com.example.nesinecasestudy.domain.model.PostModel
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(private val api: Api) : RemoteDataSource {

    override fun getPosts(): Observable<List<PostModel>> {
        return api.getPosts().map { list ->
            list.map { it.toPostModel() }
        }
    }

}