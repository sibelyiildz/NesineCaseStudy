package com.example.nesinecasestudy.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class PostUIModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val imageUrl: String?
) : Parcelable