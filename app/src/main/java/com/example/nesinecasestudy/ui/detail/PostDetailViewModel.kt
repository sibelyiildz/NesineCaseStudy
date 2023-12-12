package com.example.nesinecasestudy.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.nesinecasestudy.base.BaseViewModel
import com.example.nesinecasestudy.domain.usecase.UpdatePostTitleAndBodyUseCase
import com.example.nesinecasestudy.extension.setThreadingValue
import com.example.nesinecasestudy.extension.toLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val updatePostTitleAndBodyUseCase: UpdatePostTitleAndBodyUseCase
) : BaseViewModel() {

    private val _updatePost = MutableLiveData<Boolean>()
    val updatePost = _updatePost.toLiveData()

    fun updatePostTitleAndBody(postId: Int, title: String, body: String) {
        updatePostTitleAndBodyUseCase.execute(
            UpdatePostTitleAndBodyUseCase.Request(
                postId = postId,
                title = title,
                body = body
            )
        ) {
            _updatePost.setThreadingValue(true)
        }.attach()
    }

}