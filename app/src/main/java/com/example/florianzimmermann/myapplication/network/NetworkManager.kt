package com.example.florianzimmermann.myapplication.network

import com.example.florianzimmermann.myapplication.model.exercises.ExerciseWrapper
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class NetworkManager @Inject constructor(private val service: ApiService) {

    fun getPageAndNext(page: String): Observable<ExerciseWrapper> {
        return service.fetchExercises(page).concatMap { response: Response<ExerciseWrapper> ->
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response<ExerciseWrapper>): Observable<ExerciseWrapper?> {
        if (response.isSuccessful && response.body() != null){
            if (response.body()?.next.isNullOrEmpty()){
                return Observable.just(response.body())
            } else {
                return Observable.just(response.body()).concatWith(getPageAndNext(response.body()!!.next))
            }
        } else {
            return Observable.just(ExerciseWrapper(0, "", "", emptyList()))
        }
    }

}