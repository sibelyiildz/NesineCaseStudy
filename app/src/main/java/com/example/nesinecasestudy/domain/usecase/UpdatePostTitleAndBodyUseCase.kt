package com.example.nesinecasestudy.domain.usecase

import com.example.nesinecasestudy.base.BaseSingleRxUseCase
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.util.Result
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UpdatePostTitleAndBodyUseCase @Inject constructor(
    private val repository: Repository
) : BaseSingleRxUseCase<UpdatePostTitleAndBodyUseCase.Request, Result<Boolean>>() {

    override fun execute(request: Request): Single<Result<Boolean>> {
        return repository.updatePostTitleAndBody(
            postId = request.postId,
            title = request.title,
            body = request.body
        )
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

    data class Request(val postId: Int, val title: String, val body: String)

}
