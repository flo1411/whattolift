package com.example.florianzimmermann.myapplication.network

import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    abstract fun fetchExercises(@Url url: String): Observable<Response<ExerciseWrapper>>
}