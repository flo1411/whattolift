package com.example.florianzimmermann.myapplication

import androidx.activity.viewModels
import com.example.florianzimmermann.myapplication.fragments.LandingPageFragment
import com.example.florianzimmermann.myapplication.utils.replaceFragment
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingPageActivity : BaseActivity() {

    private val viewModel: LandingPageActivityViewModel by viewModels()

    override fun init() {
        viewModel.onStart()

        replaceFragment(LandingPageFragment.newInstance(), false)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }


}
