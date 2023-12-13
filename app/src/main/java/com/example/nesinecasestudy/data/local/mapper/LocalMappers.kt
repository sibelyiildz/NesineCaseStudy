package com.example.nesinecasestudy.data.local.mapper

import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.model.PostModel


fun PostModel.toPostEntity(): PostEntity = PostEntity(id, userId, title, body, imageUrl)