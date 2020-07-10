package com.example.florianzimmermann.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.florianzimmermann.myapplication.R
import com.example.florianzimmermann.myapplication.utils.obtainViewModel
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageFragmentViewModel
import javax.inject.Inject

class LandingPageFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: LandingPageFragmentViewModel

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

        viewModel.exercises.observe(this.viewLifecycleOwner, Observer {
            val test = 123
        })



    }
}