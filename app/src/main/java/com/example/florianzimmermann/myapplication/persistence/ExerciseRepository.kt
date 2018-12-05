package com.example.florianzimmermann.myapplication.persistence

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import io.reactivex.Single

class ExerciseRepository constructor(private val localStore: ExerciseDiskDelegate,
                                             private val networkManager: ExerciseCloudDelegate) {

    private var cachedExercises : List<Exercise> = ArrayList();

    fun getAllExercises() : Single<List<Exercise>> {
        if (cachedExercises.isNotEmpty()){
            return Single.just(cachedExercises)
        }
        return networkManager.requestAllExercises().doOnSuccess( {
            cachedExercises = it
        })
    }
}