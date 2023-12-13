package com.example.nesinecasestudy.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.nesinecasestudy.base.BaseViewModel
import com.example.nesinecasestudy.domain.usecase.UpdatePostTitleAndBodyUseCase
import com.example.nesinecasestudy.extension.setThreadingValue
import com.example.nesinecasestudy.extension.toLiveData
import com.example.nesinecasestudy.util.Result
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val updatePostTitleAndBodyUseCase: UpdatePostTitleAndBodyUseCase
) : BaseViewModel() {

    private val _updatePost = MutableLiveData<UIState<Unit>>()
    val updatePost = _updatePost.toLiveData()

    fun updatePostTitleAndBody(postId: Int, title: String, body: String) {
        _updatePost.setThreadingValue(UIState.Loading)
        updatePostTitleAndBodyUseCase.execute(
            UpdatePostTitleAndBodyUseCase.Request(
                postId = postId,
                title = title,
                body = body
            )
        ) {
            when (it) {
                is Result.Success -> {
                    _updatePost.setThreadingValue(UIState.Success(Unit))
                }

                is Result.Failure -> {
                    _updatePost.setThreadingValue(UIState.Error(it.error))
                }
            }
        }.attach()
    }

}