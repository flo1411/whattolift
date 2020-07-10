package com.example.florianzimmermann.myapplication.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageActivityViewModel
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageFragmentViewModel

class ViewModelFactory (private val exercisesUseCase: GetExercisesUseCase): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LandingPageFragmentViewModel::class.java)){
            return LandingPageFragmentViewModel(exercisesUseCase) as T
        }
        if(modelClass.isAssignableFrom(LandingPageActivityViewModel::class.java)){
            return LandingPageActivityViewModel() as T
        } else {
           throw IllegalArgumentException("Unknown ViewModel class")
       }
    }
}