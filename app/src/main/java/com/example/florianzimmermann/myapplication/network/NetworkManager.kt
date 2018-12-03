package com.example.florianzimmermann.myapplication.network

import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class NetworkManager @Inject constructor(private val service: ApiService) {

    fun getExercises(): Single<Response<kotlin.Any>> {
        return service.fetchExercises("https://wger.de/api/v2/exercise/?language=1")
    }
}