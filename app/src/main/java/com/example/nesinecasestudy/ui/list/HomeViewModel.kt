package com.example.nesinecasestudy.ui.list

import androidx.lifecycle.MutableLiveData
import com.example.nesinecasestudy.base.BaseViewModel
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.domain.usecase.GetPostsUseCase
import com.example.nesinecasestudy.extension.setThreadingValue
import com.example.nesinecasestudy.extension.toLiveData
import com.example.nesinecasestudy.util.Result
import com.example.nesinecasestudy.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : BaseViewModel() {

    private val _posts = MutableLiveData<UIState<List<PostResponse>>>()
    val posts = _posts.toLiveData()

    fun fetchPosts() {
        _posts.setThreadingValue(UIState.Loading)
        getPostsUseCase.execute(Unit) {
            when (it) {
                is Result.Success -> {
                    _posts.setThreadingValue(UIState.Success(it.data))
                }

                is Result.Failure -> {
                    _posts.setThreadingValue(UIState.Error(it.error))
                }
            }
        }.attach()
    }

}