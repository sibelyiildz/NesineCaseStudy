package com.example.nesinecasestudy.data.local.mapper

import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.model.PostUIModel


fun PostUIModel.toPostEntity(): PostEntity = PostEntity(id, userId, title, body, imageUrl)