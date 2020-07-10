package com.example.florianzimmermann.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.utils.extensions.map
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LandingPageFragmentViewModel @Inject constructor(private val getExercisesUseCase: GetExercisesUseCase) : ViewModel() {

    val exercises : LiveData<List<Exercise>>
    private var search: Disposable? = null

    init {
        exercises = getExercisesUseCase.observe().map {
            (it as? Result.Success<List<Exercise>>)?.data ?: emptyList()
        }

        getExercisesUseCase.execute(Unit)
    }

}