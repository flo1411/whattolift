package com.example.florianzimmermann.myapplication.utils


import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.florianzimmermann.myapplication.BaseActivity
import com.example.florianzimmermann.myapplication.R

fun AppCompatActivity.toast(message : String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, addToStack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction()
    //transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
    transaction.replace(R.id.contentFrame, fragment)
    if (addToStack) {
        transaction.addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

inline fun <reified VM : ViewModel> BaseActivity.obtainViewModel() =
        ViewModelProviders.of(this, factory).get(VM::class.java)