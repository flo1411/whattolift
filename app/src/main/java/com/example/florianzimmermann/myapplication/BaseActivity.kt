package com.example.florianzimmermann.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        init()
    }

    abstract fun getLayout() : Int
    abstract fun init()
}