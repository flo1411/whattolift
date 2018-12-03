package com.example.florianzimmermann.myapplication.di.modules

import com.example.florianzimmermann.myapplication.LandingPageActivity
import com.example.florianzimmermann.myapplication.fragments.LandingPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(LandingPageActivityModule::class)])
    abstract fun bindLandingPageActivity() : LandingPageActivity

    @ContributesAndroidInjector(modules = [(LandingPageFragmentModule::class)])
    abstract fun bindLandingPageFragment() : LandingPageFragment
}