package com.example.florianzimmermann.myapplication.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory (private val exercisesUseCase: GetExercisesUseCase): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(LandingPageViewModel::class.java)){
           return LandingPageViewModel(exercisesUseCase) as T
       } else {
           throw IllegalArgumentException("Unknown ViewModel class")
       }
    }
}