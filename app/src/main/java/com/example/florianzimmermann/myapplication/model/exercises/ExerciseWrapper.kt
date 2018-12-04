package com.example.florianzimmermann.myapplication.model.exercises

import com.google.gson.annotations.SerializedName

data class ExerciseWrapper (

    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val results : List<Exercise>
)