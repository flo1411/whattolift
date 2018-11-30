package com.example.florianzimmermann.myapplication.model.exercises

data class ExerciseRequestFailedException(val reason: String? = "") : Exception()