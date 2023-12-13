package com.example.nesinecasestudy.domain.usecase

import com.example.nesinecasestudy.base.BaseObservableRxUseCase
import com.example.nesinecasestudy.domain.model.PostModel
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.util.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GetPostFromLocalUseCase @Inject constructor(
    private val repository: Repository,
) : BaseObservableRxUseCase<Unit, Result<List<PostModel>>>() {
    override fun execute(request: Unit): Observable<Result<List<PostModel>>> {
        return repository.getAllPostFromLocal()
            .map {
                Result.Success(it) as Result<List<PostModel>>
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn {
                Result.Failure(it)
            }
    }

}