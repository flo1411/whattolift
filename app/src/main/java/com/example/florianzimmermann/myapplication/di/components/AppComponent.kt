package com.example.florianzimmermann.myapplication.di.components

import android.app.Application
import com.example.florianzimmermann.myapplication.LiftApplication
import com.example.florianzimmermann.myapplication.di.modules.AppModule
import com.example.florianzimmermann.myapplication.di.modules.ViewModelModule
import com.example.florianzimmermann.myapplication.fragments.BaseFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: LiftApplication)

    fun plusLandingPageComponent() : LandingPageComponent

    //fun inject(baseFragment: BaseFragment)
}