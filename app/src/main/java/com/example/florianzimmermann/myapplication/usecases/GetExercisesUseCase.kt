package com.example.florianzimmermann.myapplication.usecases

import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseRequestFailedException
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import com.example.florianzimmermann.myapplication.persistence.ExerciseRepository
import com.example.florianzimmermann.myapplication.utils.MediatorUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GetExercisesUseCase(private val exerciseRepo: ExerciseRepository) : MediatorUseCase<Unit, List<kotlin.Any>>() {

    private val compositeDisposable = CompositeDisposable()

    override fun execute(parameters: Unit) {
        compositeDisposable.add(exerciseRepo.requestAllExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList()
                .subscribe({ response -> onExcerciseResult(response) }, { throwable -> onError(throwable) }))
    }

    private fun onExcerciseResult(response: MutableList<ExerciseWrapper>) {
        val exercises : ArrayList<Exercise> = ArrayList()
        for (item : ExerciseWrapper in response){
            exercises.addAll(item.results)
        }
        result.postValue(Result.Success(exercises))
    }

    private fun onError(throwable: Throwable) {
        result.postValue(Result.Error(ExerciseRequestFailedException(throwable.message)))
    }

}