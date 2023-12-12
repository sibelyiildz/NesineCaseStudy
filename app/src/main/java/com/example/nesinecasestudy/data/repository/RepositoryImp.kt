package com.example.nesinecasestudy.data.repository

import com.example.nesinecasestudy.data.local.PostDao
import com.example.nesinecasestudy.data.local.PostEntity
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.data.remote.service.Api
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.extension.getFullImageUrl
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val api: Api, private val postDao: PostDao) :
    Repository {

    override fun getPosts(): Observable<List<PostResponse>> {
        return api.getPosts()
    }

    override fun fetchAndSave(): Completable {
        return api.getPosts()
            .map {
                it.mapIndexed { index, post ->
                    post.copy(imageUrl = getFullImageUrl(index))
                }
            }
            .concatMapCompletable { posts ->
                val postEntities = posts.map { post ->
                    PostEntity(post.id, post.userId, post.title, post.body, post.imageUrl)
                }
                postDao.insertPosts(postEntities)
            }
    }

    override fun getAllPostFromLocal(): Observable<List<PostResponse>> {
        return postDao.getAllPosts().map {
            it.map {
                PostResponse (it.id, it.userId, it.title, it.body, it.imageUrl)
            }
        }
    }

}