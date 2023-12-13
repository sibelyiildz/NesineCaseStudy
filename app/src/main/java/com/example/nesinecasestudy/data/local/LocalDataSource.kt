package com.example.nesinecasestudy.data.local

import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.model.PostModel
import io.reactivex.Completable
import io.reactivex.Observable

interface LocalDataSource {

    fun savePosts(postEntities: List<PostEntity>): Completable

    fun getAllPostFromLocal(): Observable<List<PostModel>>

    fun deletePost(postId: Int): Completable

    fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable
}