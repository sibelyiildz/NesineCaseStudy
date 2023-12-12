package com.example.nesinecasestudy.domain.mapper

import com.example.nesinecasestudy.data.local.entity.PostEntity
import com.example.nesinecasestudy.domain.model.PostUIModel


fun PostEntity.toPostUIModel(): PostUIModel = PostUIModel(id, userId, title, body, imageUrl)