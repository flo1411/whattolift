package com.example.florianzimmermann.myapplication.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.florianzimmermann.myapplication.fragments.BaseFragment

/**
 * Obtain viewModel. Automatically takes the correct viewModel based on it's fragment variable declaration
 * Bound to fragment scope.
 */
inline fun <reified VM : ViewModel> BaseFragment.obtainViewModel() =
        ViewModelProviders.of(this, viewModelFactory).get(VM::class.java)

/**
 * @see obtainViewModel but takes activity as argument to get same instance of the view model
 * Bound to activity scope
 */
inline fun <reified VM : ViewModel> BaseFragment.obtainViewModel(activity: FragmentActivity) =
        ViewModelProviders.of(activity, viewModelFactory).get(VM::class.java)