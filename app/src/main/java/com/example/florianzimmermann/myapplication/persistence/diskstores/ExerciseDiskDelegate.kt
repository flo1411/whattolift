package com.example.florianzimmermann.myapplication.persistence.diskstores

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import io.reactivex.Single

interface ExerciseDiskDelegate {

    fun requestAllExercises(): Single<List<Exercise>>
    fun setAllExercises(exercises : List<Exercise>)
    fun hasExercisesSaved() : Boolean
}