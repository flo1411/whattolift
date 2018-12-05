package com.example.florianzimmermann.myapplication.usecases

import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseRequestFailedException
import com.example.florianzimmermann.myapplication.persistence.ExerciseRepository
import com.example.florianzimmermann.myapplication.utils.MediatorUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GetExercisesUseCase(private val exerciseRepo: ExerciseRepository) : MediatorUseCase<Unit, List<Exercise>>() {

    private val compositeDisposable = CompositeDisposable()

    override fun execute(parameters: Unit) {
        compositeDisposable.add(
                exerciseRepo.getAllExercises()
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe( {response -> onExcerciseResult(response) }, { throwable -> onError(throwable) })
        )
    }

    private fun onExcerciseResult(response: List<Exercise>) {
        result.postValue(Result.Success(response))
    }

    private fun onError(throwable: Throwable) {
        result.postValue(Result.Error(ExerciseRequestFailedException(throwable.message)))
    }

}