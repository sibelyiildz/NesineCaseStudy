package com.example.nesinecasestudy.domain.repository

import com.example.nesinecasestudy.domain.model.PostModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

    fun fetchAndSave(): Completable

    fun getAllPostFromLocal(): Observable<List<PostModel>>

    fun deletePost(postId: Int): Single<Boolean>

    fun updatePostTitleAndBody(postId: Int, title: String, body: String): Single<Boolean>
}