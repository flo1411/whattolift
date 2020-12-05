package com.example.florianzimmermann.myapplication.persistence

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import io.reactivex.Single
import javax.inject.Inject

class ExerciseRepository @Inject constructor(private val localStore: ExerciseDiskDelegate,
                                             private val networkManager: ExerciseCloudDelegate) {

    fun getAllExercises() : Single<List<Exercise>> {
        if (localStore.hasExercisesSaved()){
            return localStore.requestAllExercises()
        }
        return networkManager.requestAllExercises().doOnSuccess {
            localStore.setAllExercises(it)
        }
    }
}