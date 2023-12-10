package com.example.nesinecasestudy.base

import androidx.annotation.CheckResult
import com.example.nesinecasestudy.BuildConfig
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

abstract class BaseRxUseCase<REQUEST, RESPONSE> : RxUseCase<REQUEST, RESPONSE> {

    @CheckResult
    override fun execute(request: REQUEST, data: Consumer<RESPONSE>): Disposable {
        return execute(request).subscribe(data) { t ->
            if (BuildConfig.DEBUG) {
                t.printStackTrace()
            }
        }
    }
}

interface RxUseCase<REQUEST, RESPONSE> {
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