package com.example.nesinecasestudy.domain.usecase

import android.annotation.SuppressLint
import com.example.nesinecasestudy.base.BaseRxUseCase
import com.example.nesinecasestudy.data.remote.model.PostResponse
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.util.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GetPostFromLocalUseCase @Inject constructor(
    private val repository: Repository
) : BaseRxUseCase<Unit, Result<List<PostResponse>>>() {
    @SuppressLint("CheckResult")
    override fun execute(request: Unit): Observable<Result<List<PostResponse>>> {
        return Observable.create { source ->
            repository.getAllPostFromLocal()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (source.isDisposed) return@subscribe
                    source.onNext(Result.Success(response))
                    source.onComplete()
                }, { throwable ->
                    if (source.isDisposed) return@subscribe
                    source.onNext(Result.Failure(throwable))
                    source.onComplete()
                })
        }
    }

}