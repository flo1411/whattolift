package com.example.florianzimmermann.myapplication.network

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    abstract fun fetchExercises(@Url url: String): Single<Response<kotlin.Any>>
}