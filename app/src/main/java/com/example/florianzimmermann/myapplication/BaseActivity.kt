package com.example.florianzimmermann.myapplication

import android.os.Bundle
import com.example.florianzimmermann.myapplication.utils.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        init()
    }

    abstract fun getLayout() : Int
    abstract fun init()
}