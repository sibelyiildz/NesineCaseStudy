package com.example.nesinecasestudy.data.local

import com.example.nesinecasestudy.data.remote.model.PostResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class LocalDataSourceImp @Inject constructor(private val postDao: PostDao) : LocalDataSource {

    override fun savePosts(postEntities: List<PostEntity>): Completable {
        return postDao.insertPosts(postEntities)
    }

    override fun getAllPostFromLocal(): Observable<List<PostResponse>> {
        return postDao.getAllPosts().map {
            it.map {
                PostResponse(it.id, it.userId, it.title, it.body, it.imageUrl)
            }
        }
    }

    override fun deletePost(postId: Int): Completable {
        return postDao.deletePost(postId)
    }

    override fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable {
        return postDao.updatePostTitleAndBody(postId, title, body)
    }

}