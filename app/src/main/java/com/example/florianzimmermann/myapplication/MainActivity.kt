package com.example.florianzimmermann.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.florianzimmermann.myapplication.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.contentFrame, MainFragment.newInstance(), "mainFragment")
                    .commit()
        }
    }
}
