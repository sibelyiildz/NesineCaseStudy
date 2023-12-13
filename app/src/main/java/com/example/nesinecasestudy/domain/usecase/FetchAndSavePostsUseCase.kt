package com.example.nesinecasestudy.domain.usecase

import com.example.nesinecasestudy.base.BaseObservableRxUseCase
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
) : BaseObservableRxUseCase<Unit, Result<List<PostModel>>>() {

    override fun execute(request: Unit): Observable<Result<List<PostModel>>> {
        return repository.fetchAndSave()
            .andThen(getPostFromLocalUseCase.execute(Unit))
            .concatMap { getPostFromLocalUseCase.execute(Unit) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { e ->
                Result.Failure(e)
            }
    }

}