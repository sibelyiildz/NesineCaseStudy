package com.example.nesinecasestudy.data.remote.mapper

import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.domain.model.PostUIModel


fun PostResponse.toPostUIModel(): PostUIModel = PostUIModel(id, userId, title, body, imageUrl)