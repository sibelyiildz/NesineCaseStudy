package com.example.nesinecasestudy.data.repository

import com.example.nesinecasestudy.data.local.LocalDataSource
import com.example.nesinecasestudy.data.local.mapper.toPostEntity
import com.example.nesinecasestudy.data.remote.RemoteDataSource
import com.example.nesinecasestudy.domain.model.PostUIModel
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.extension.getFullImageUrl
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override fun fetchAndSave(): Completable {
        return remoteDataSource.getPosts().map {
            it.mapIndexed { index, post ->
                post.copy(imageUrl = getFullImageUrl(index))
            }
        }.concatMapCompletable { posts ->
            localDataSource.savePosts(posts.map { it.toPostEntity() })
        }
    }

    override fun getAllPostFromLocal(): Observable<List<PostUIModel>> {
        return localDataSource.getAllPostFromLocal()
    }

    override fun deletePost(postId: Int): Completable {
        return localDataSource.deletePost(postId)
    }

    override fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable {
        return localDataSource.updatePostTitleAndBody(postId, title, body)
    }

}