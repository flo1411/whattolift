package com.example.florianzimmermann.myapplication.persistence

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

class ExerciseRepository constructor(private val localStore: ExerciseDiskDelegate,
                                             private val networkManager: ExerciseCloudDelegate) {

    fun requestAllExercises() : Observable<ExerciseWrapper> {

        return networkManager.requestAllExercises();
    }
}