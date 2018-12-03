package com.example.florianzimmermann.myapplication.di.modules

import android.arch.lifecycle.ViewModel
import com.example.florianzimmermann.myapplication.di.scopes.ViewModelKey
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LandingPageModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(LandingPageViewModel::class)
//    abstract fun bindLandingPageViewModel(viewModel: LandingPageViewModel) : ViewModelKey
}