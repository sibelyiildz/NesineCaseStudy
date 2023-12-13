package com.example.nesinecasestudy.data.remote.mapper

import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.domain.model.PostModel


fun PostResponse.toPostModel(): PostModel = PostModel(id, userId, title, body, imageUrl)