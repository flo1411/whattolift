package com.example.florianzimmermann.myapplication.persistence.cloudstores

import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface ExerciseCloudDelegate {

    fun requestAllExercises() : Observable<ExerciseWrapper>
}