package com.example.florianzimmermann.myapplication.persistence.cloudstores

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import com.example.florianzimmermann.myapplication.network.NetworkManager
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class ExerciseCloudStore @Inject constructor(private val networkManager: NetworkManager) : ExerciseCloudDelegate {

    override fun requestAllExercises(): Single<List<Exercise>> {
        return networkManager.getPageAndNext("https://wger.de/api/v2/exercise/?language=1")
                .toList()
                .map { it -> it.flatMap { it.results } }
    }
}