package com.example.nesinecasestudy.domain.repository

import com.example.nesinecasestudy.data.remote.model.PostResponse
import io.reactivex.Completable
import io.reactivex.Observable

interface Repository {

    fun getPosts(): Observable<List<PostResponse>>

    fun fetchAndSave(): Completable

    fun getAllPostFromLocal(): Observable<List<PostResponse>>

    fun deletePost(postId: Int): Completable

    fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable
}