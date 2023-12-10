package com.example.nesinecasestudy.domain.repository

import com.example.nesinecasestudy.data.remote.model.PostsResponse

interface Repository {

    fun getPosts(): PostsResponse
}