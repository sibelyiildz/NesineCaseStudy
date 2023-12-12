package com.example.nesinecasestudy.data.remote.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    val imageUrl: String?
) : Parcelable