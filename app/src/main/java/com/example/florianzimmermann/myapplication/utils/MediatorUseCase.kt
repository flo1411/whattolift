package com.example.florianzimmermann.myapplication.utils

import androidx.lifecycle.MediatorLiveData
import com.example.florianzimmermann.myapplication.model.Result

abstract class MediatorUseCase<in P, R> {

    protected val result = MediatorLiveData<Result<R>>()

    // open so that mock instances can mock this method
    open fun observe(): MediatorLiveData<Result<R>> {
        return result
    }

    abstract fun execute(parameters: P)
}