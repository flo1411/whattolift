package com.example.florianzimmermann.myapplication.di.components

import com.example.florianzimmermann.myapplication.di.modules.LandingPageModule
import com.example.florianzimmermann.myapplication.di.scopes.LandingPageScoped
import com.example.florianzimmermann.myapplication.fragments.LandingPageFragment
import dagger.Subcomponent

@LandingPageScoped
@Subcomponent(modules = [LandingPageModule::class])
interface LandingPageComponent {

    //fun inject(landinPageFragment: LandingPageFragment)
}