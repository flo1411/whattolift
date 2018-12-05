package com.example.florianzimmermann.myapplication.persistence.cloudstores

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface ExerciseCloudDelegate {

    fun requestAllExercises(): Single<List<Exercise>>
}