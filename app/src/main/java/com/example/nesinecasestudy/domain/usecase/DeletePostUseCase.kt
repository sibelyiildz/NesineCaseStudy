package com.example.nesinecasestudy.domain.usecase

import android.annotation.SuppressLint
import com.example.nesinecasestudy.base.BaseSingleRxUseCase
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.util.Result
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: Repository
) : BaseSingleRxUseCase<DeletePostUseCase.Request, Result<Boolean>>() {
    @SuppressLint("CheckResult")
    override fun execute(request: Request): Single<Result<Boolean>> {
        return repository.deletePost(postId = request.postId)
            .map {
                if (it) {
                    Result.Success(it)
                } else {
                    Result.Failure(NullPointerException())
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    data class Request(val postId: Int)

}