package com.example.florianzimmermann.myapplication.usecases

import com.example.florianzimmermann.myapplication.model.Result
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseRequestFailedException
import com.example.florianzimmermann.myapplication.persistence.ExerciseRepository
import com.example.florianzimmermann.myapplication.utils.MediatorUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(private val exerciseRepo: ExerciseRepository) : MediatorUseCase<Unit, List<kotlin.Any>>() {

    private val compositeDisposable = CompositeDisposable()

    override fun execute(parameters: Unit) {
        compositeDisposable.add(exerciseRepo.requestAllExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response -> onExcerciseResult(response) }, { throwable -> onError(throwable) }))
    }

    private fun onExcerciseResult(response: Response<Any>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onError(throwable: Throwable) {
        result.postValue(Result.Error(ExerciseRequestFailedException(throwable.message)))
    }
}