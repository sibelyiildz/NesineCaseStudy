package com.example.nesinecasestudy.domain.usecase

import android.annotation.SuppressLint
import com.example.nesinecasestudy.base.BaseRxUseCaseCompletable
import com.example.nesinecasestudy.domain.repository.Repository
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UpdatePostTitleAndBodyUseCase @Inject constructor(
    private val repository: Repository
) : BaseRxUseCaseCompletable<UpdatePostTitleAndBodyUseCase.Request>() {
    @SuppressLint("CheckResult")
    override fun execute(request: Request): Completable {
        return Completable.create { source ->
            repository.updatePostTitleAndBody(
                postId = request.postId,
                title = request.title,
                body = request.body
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (source.isDisposed) return@subscribe
                    /*  source.onNext(Result.Success(Unit))*/
                    source.onComplete()
                }, { throwable ->
                    if (source.isDisposed) return@subscribe
                    /*  source.onNext(Result.Failure(throwable))*/
                    source.onComplete()
                })
        }
    }

    data class Request(val postId: Int, val title: String, val body: String)


}


/*
class DeletePostUseCase @Inject constructor(private val repository: Repository) :
    BaseRxUseCase<DeletePostUseCase.Request, Boolean>() {
    @SuppressLint("CheckResult")
    override fun execute(request: Request): Observable<Boolean> {
        return Observable.create { source ->
            repository.deletePost(request.postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable<Boolean>()
                .subscribe({
                    if (source.isDisposed) return@subscribe
                    source.onNext(true)
                    source.onComplete()
                }, { throwable ->
                    if (source.isDisposed) return@subscribe
                    source.onNext(false)
                    source.onComplete()
                })
        }
    }

    data class Request(val postId: Int)
}
*/
