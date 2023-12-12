package com.example.nesinecasestudy.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(users: List<PostEntity>): Completable

    @Query("SELECT * FROM post")
    fun getAllPosts(): Observable<List<PostEntity>>

    @Query("DELETE FROM post WHERE id = :id")
    fun deletePost(id: Int): Completable

    @Query("UPDATE post SET title = :newTitle, body = :newBody WHERE id = :postId")
    fun updatePostTitleAndBody(postId: Int, newTitle: String, newBody: String): Completable
}