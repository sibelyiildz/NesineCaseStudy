package com.example.nesinecasestudy.domain.repository

import com.example.nesinecasestudy.domain.model.PostUIModel
import io.reactivex.Completable
import io.reactivex.Observable

interface Repository {

    fun fetchAndSave(): Completable

    fun getAllPostFromLocal(): Observable<List<PostUIModel>>

    fun deletePost(postId: Int): Completable

    fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable
}