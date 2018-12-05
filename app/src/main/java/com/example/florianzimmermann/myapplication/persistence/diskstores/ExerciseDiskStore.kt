package com.example.florianzimmermann.myapplication.persistence.diskstores

import com.example.florianzimmermann.myapplication.model.exercises.Exercise
import io.reactivex.Single
import javax.inject.Inject

class ExerciseDiskStore @Inject constructor() : ExerciseDiskDelegate {

    private var cachedExercises : List<Exercise> = ArrayList();

    override fun setAllExercises(exercises: List<Exercise>) {
        this.cachedExercises = exercises
    }

    override fun requestAllExercises(): Single<List<Exercise>> {
        return Single.just(cachedExercises)
    }

    override fun hasExercisesSaved(): Boolean {
        return cachedExercises.isNotEmpty()
    }
}