package com.example.florianzimmermann.myapplication.utils.extensions

import android.arch.core.util.Function
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.utils.NonNullMediatorLiveData

fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

/**
 * Maps Result<Boolean> to Boolean
 */
fun LiveData<Result<Boolean>>.mapSuccessBoolean(): LiveData<Boolean> {

    val func = Function<Result<Boolean>, Boolean> {
        when (it) {
            is Result.Success<Boolean> -> it.data
            is Result.Error -> throw it.exception
        }
    }

    val result = MediatorLiveData<Boolean>()
    result.addSource(Transformations.map(this, func)) {
        result.value = it!!
    }

    return result
}

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> = NonNullMediatorLiveData()
    mediator.addSource(this) { it?.let { mediator.value = it } }
    return mediator
}

fun <T> NonNullMediatorLiveData<T>.observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer { it?.let(observer) })
}