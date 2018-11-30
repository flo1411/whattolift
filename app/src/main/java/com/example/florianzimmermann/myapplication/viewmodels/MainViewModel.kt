package com.example.florianzimmermann.myapplication.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getExercisesUseCase: GetExercisesUseCase) : ViewModel() {

    private var search: Disposable? = null

    init {

    }
}