package com.example.florianzimmermann.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.florianzimmermann.myapplication.R
import com.example.florianzimmermann.myapplication.di.components.AppComponent
import com.example.florianzimmermann.myapplication.utils.obtainViewModel
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageViewModel

class LandingPageFragment : BaseFragment() {

    lateinit var viewModel: LandingPageViewModel

    companion object {
        fun newInstance(): BaseFragment {
            return LandingPageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = obtainViewModel()
        var test = 12
    }
}