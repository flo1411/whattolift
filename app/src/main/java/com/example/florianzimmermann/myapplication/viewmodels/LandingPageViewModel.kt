package com.example.florianzimmermann.myapplication.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.utils.extensions.map
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LandingPageViewModel @Inject constructor(private val getExercisesUseCase: GetExercisesUseCase) : ViewModel() {

    private var search: Disposable? = null

    init {
        getExercisesUseCase.observe().map {
            (it as? Result.Success<List<kotlin.Any>>)?.data ?: emptyList()
        }
    }
}