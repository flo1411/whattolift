package com.example.florianzimmermann.myapplication.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.florianzimmermann.myapplication.utils.ViewModelFactory
import dagger.android.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return childFragmentInjector
    }
}