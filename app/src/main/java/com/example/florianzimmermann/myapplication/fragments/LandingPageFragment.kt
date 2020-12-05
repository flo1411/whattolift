package com.example.florianzimmermann.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.florianzimmermann.myapplication.R
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingPageFragment : BaseFragment() {

    private val viewModel: LandingPageFragmentViewModel by viewModels()

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
        viewModel.exercises.observe(this.viewLifecycleOwner, Observer {
            val test = 123
        })



    }
}