package com.example.florianzimmermann.myapplication.persistence.cloudstores

import com.example.florianzimmermann.myapplication.network.NetworkManager
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class ExerciseCloudStore (private val networkManager: NetworkManager) : ExerciseCloudDelegate {

    override fun requestAllExercises(): Single<Response<Any>> {
        return networkManager.getExercises()
    }

}