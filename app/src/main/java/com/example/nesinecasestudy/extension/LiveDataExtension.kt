package com.example.nesinecasestudy.extension

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nesinecasestudy.util.LiveEvent

fun <T> MutableLiveData<T>.toLiveData(): LiveData<T> {
    return this
}

fun <T> LiveData<T>.toSingleEvent(isSkipFirst: Boolean = false): LiveData<T> {
    val result = LiveEvent<T>()
    var isFirst = true
    result.addSource(this) {
        if (isSkipFirst) {
            if (isFirst) isFirst = false
            else result.value = it
        } else {
            result.value = it
        }

    }
    return result
}


fun <T> MutableLiveData<T>.setThreadingValue(data: T) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        this.value = data
    } else {
        this.postValue(data)
    }
}
