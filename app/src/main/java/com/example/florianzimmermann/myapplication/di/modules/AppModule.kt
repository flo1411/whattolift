package com.example.florianzimmermann.myapplication.di.modules

import android.app.Application
import android.content.Context
import com.example.florianzimmermann.myapplication.network.ApiService
import com.example.florianzimmermann.myapplication.network.NetworkManager
import com.example.florianzimmermann.myapplication.persistence.ExerciseRepository
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudStore
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskStore
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.viewmodels.LandingPageFragmentViewModel
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
class AppModule() {

    @Provides
    fun provideContext(application: Application) : Context {
        return application
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideApiService(gson : Gson) : ApiService{
        return Retrofit.Builder()
                .baseUrl("https://wger.de")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    fun provideExerciseCloudStore(networkManager: NetworkManager) : ExerciseCloudDelegate {
        return ExerciseCloudStore(networkManager)
    }

    @Provides
    fun provideExerciseLocalStore() : ExerciseDiskDelegate {
        return ExerciseDiskStore()
    }

    @Provides
    fun provideExerciseRepository(cloudStore: ExerciseCloudStore, diskStore: ExerciseDiskStore) : ExerciseRepository{
        return ExerciseRepository(diskStore, cloudStore)
    }

    @Provides
    fun provideExercisesUseCase(exerciseRepository: ExerciseRepository) : GetExercisesUseCase{
        return GetExercisesUseCase(exerciseRepository)
    }

}