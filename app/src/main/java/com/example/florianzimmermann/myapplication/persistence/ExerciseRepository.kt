package com.example.florianzimmermann.myapplication.persistence

import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class ExerciseRepository constructor(private val localStore: ExerciseDiskDelegate,
                                             private val networkManager: ExerciseCloudDelegate) {

    fun requestAllExercises() : Single<Response<Any>>{

        return networkManager.requestAllExercises();
    }
}