package com.example.nesinecasestudy.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val imageUrl: String?
) : Parcelable