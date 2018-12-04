package com.example.florianzimmermann.myapplication.model.exercises

import com.google.gson.annotations.SerializedName

class Exercise (

    @SerializedName("id") val id : Int,
    @SerializedName("license_author") val license_author : String,
    @SerializedName("status") val status : Int,
    @SerializedName("description") val description : String,
    @SerializedName("name") val name : String,
    @SerializedName("name_original") val name_original : String,
    @SerializedName("creation_date") val creation_date : String,
    @SerializedName("uuid") val uuid : String,
    @SerializedName("license") val license : Int,
    @SerializedName("category") val category : Int,
    @SerializedName("language") val language : Int,
    @SerializedName("muscles") val muscles : List<Int>,
    @SerializedName("muscles_secondary") val muscles_secondary : List<Int>,
    @SerializedName("equipment") val equipment : List<String>
)