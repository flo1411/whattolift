package com.example.florianzimmermann.myapplication.fragments

import android.content.Context
import android.support.v4.app.Fragment
import com.example.florianzimmermann.myapplication.utils.ViewModelFactory
import dagger.android.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment>? {
        return childFragmentInjector
    }

}