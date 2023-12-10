package com.example.nesinecasestudy.data.repository

import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.data.remote.service.Api
import com.example.nesinecasestudy.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val api: Api) : Repository {

    override fun getPosts(): Observable<List<PostResponse>> {
        return api.getPosts()
    }
}