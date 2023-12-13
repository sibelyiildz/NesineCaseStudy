package com.example.nesinecasestudy.domain.usecase

import android.annotation.SuppressLint
import com.example.nesinecasestudy.base.BaseRxUseCase
import com.example.nesinecasestudy.domain.model.PostModel
import com.example.nesinecasestudy.domain.repository.Repository
import com.example.nesinecasestudy.util.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FetchAndSavePostsUseCase @Inject constructor(
    private val repository: Repository,
    private val getPostFromLocalUseCase: GetPostFromLocalUseCase
) : BaseRxUseCase<Unit, Result<List<PostModel>>>() {
    @SuppressLint("CheckResult")
    override fun execute(request: Unit): Observable<Result<List<PostModel>>> {
        return Observable.create { source ->
            repository.fetchAndSave()
                .andThen(getPostFromLocalUseCase.execute(Unit))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (source.isDisposed) return@subscribe
                    source.onNext(response)
                    source.onComplete()
                }, { throwable ->
                    if (source.isDisposed) return@subscribe
                    source.onNext(Result.Failure(throwable))
                    source.onComplete()
                })
        }
    }

}