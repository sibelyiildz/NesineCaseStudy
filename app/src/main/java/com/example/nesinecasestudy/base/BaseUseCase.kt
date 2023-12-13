package com.example.nesinecasestudy.base

import androidx.annotation.CheckResult
import com.example.nesinecasestudy.BuildConfig
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

abstract class BaseObservableRxUseCase<REQUEST, RESPONSE> : ObservableRxUseCase<REQUEST, RESPONSE> {

    @CheckResult
    override fun execute(request: REQUEST, data: Consumer<RESPONSE>): Disposable {
        return execute(request).subscribe(data) { t ->
            if (BuildConfig.DEBUG) {
                t.printStackTrace()
            }
        }
    }
}

interface ObservableRxUseCase<REQUEST, RESPONSE> {
    @CheckResult
    fun execute(request: REQUEST): Observable<RESPONSE>

    @CheckResult
    fun execute(request: REQUEST, data: Consumer<RESPONSE>): Disposable {
        return execute(request).subscribe(data) { t ->
            if (BuildConfig.DEBUG) {
                t.printStackTrace()
            }
        }
    }
}

abstract class BaseSingleRxUseCase<REQUEST, RESPONSE> : RxSingleUseCase<REQUEST, RESPONSE> {

    @CheckResult
    override fun execute(request: REQUEST, data: Consumer<RESPONSE>): Disposable {
        return execute(request).subscribe(data) { t ->
            if (BuildConfig.DEBUG) {
                t.printStackTrace()
            }
        }
    }
}

interface RxSingleUseCase<REQUEST, RESPONSE> {
    @CheckResult
    fun execute(request: REQUEST): Single<RESPONSE>

    @CheckResult
    fun execute(request: REQUEST, data: Consumer<RESPONSE>): Disposable {
        return execute(request).subscribe(data) { t ->
            if (BuildConfig.DEBUG) {
                t.printStackTrace()
            }
        }
    }
}