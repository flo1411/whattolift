package com.example.florianzimmermann.myapplication.persistence.cloudstores

import io.reactivex.Single
import retrofit2.Response

interface ExerciseCloudDelegate {

    fun requestAllExercises() : Single<Response<Any>>
}