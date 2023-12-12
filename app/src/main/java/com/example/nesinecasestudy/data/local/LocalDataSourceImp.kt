package com.example.nesinecasestudy.data.local

import com.example.nesinecasestudy.data.local.dao.PostDao
import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.mapper.toPostUIModel
import com.example.nesinecasestudy.domain.model.PostUIModel
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class LocalDataSourceImp @Inject constructor(private val postDao: PostDao) : LocalDataSource {

    override fun savePosts(postEntities: List<PostEntity>): Completable {
        return postDao.insertPosts(postEntities)
    }

    override fun getAllPostFromLocal(): Observable<List<PostUIModel>> {
        return postDao.getAllPosts().map { list ->
            list.map { it.toPostUIModel() }
        }
    }

    override fun deletePost(postId: Int): Completable {
        return postDao.deletePost(postId)
    }

    override fun updatePostTitleAndBody(postId: Int, title: String, body: String): Completable {
        return postDao.updatePostTitleAndBody(postId, title, body)
    }

}