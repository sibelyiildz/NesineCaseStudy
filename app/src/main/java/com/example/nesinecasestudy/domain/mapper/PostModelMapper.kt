package com.example.nesinecasestudy.domain.mapper

import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.model.PostModel


fun PostEntity.toPostModel(): PostModel = PostModel(id, userId, title, body, imageUrl)