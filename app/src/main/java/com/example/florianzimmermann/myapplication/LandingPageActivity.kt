package com.example.florianzimmermann.myapplication

import com.example.florianzimmermann.myapplication.fragments.LandingPageFragment
import com.example.florianzimmermann.myapplication.utils.obtainViewModel
import com.example.florianzimmermann.myapplication.utils.replaceFragment
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageActivityViewModel


class LandingPageActivity : BaseActivity() {

    override fun init() {
        viewModel = obtainViewModel()
        viewModel.onStart()

        replaceFragment(LandingPageFragment.newInstance(), false)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    private lateinit var viewModel: LandingPageActivityViewModel

}
