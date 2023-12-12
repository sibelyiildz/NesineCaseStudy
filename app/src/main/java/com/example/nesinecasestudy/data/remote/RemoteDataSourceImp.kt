package com.example.nesinecasestudy.data.remote

import com.example.nesinecasestudy.data.remote.mapper.toPostUIModel
import com.example.nesinecasestudy.data.remote.service.Api
import com.example.nesinecasestudy.domain.model.PostUIModel
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(private val api: Api) : RemoteDataSource {

    override fun getPosts(): Observable<List<PostUIModel>> {
        return api.getPosts().map { list ->
            list.map { it.toPostUIModel() }
        }
    }

}