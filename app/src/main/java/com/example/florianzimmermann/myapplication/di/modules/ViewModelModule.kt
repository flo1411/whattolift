package com.example.florianzimmermann.myapplication.di.modules

import android.arch.lifecycle.ViewModelProvider
import com.example.florianzimmermann.myapplication.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory
}