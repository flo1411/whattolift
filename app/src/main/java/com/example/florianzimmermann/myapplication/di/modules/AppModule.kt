package com.example.florianzimmermann.myapplication.di.modules

import android.app.Application
import android.content.Context
import com.example.florianzimmermann.myapplication.LiftApplication
import com.example.florianzimmermann.myapplication.network.ApiService
import com.example.florianzimmermann.myapplication.network.NetworkManager
import com.example.florianzimmermann.myapplication.persistence.ExerciseRepository
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudDelegate
import com.example.florianzimmermann.myapplication.persistence.cloudstores.ExerciseCloudStore
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskDelegate
import com.example.florianzimmermann.myapplication.persistence.diskstores.ExerciseDiskStore
import com.example.florianzimmermann.myapplication.usecases.GetExercisesUseCase
import com.example.florianzimmermann.myapplication.utils.ViewModelFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides
    fun provideContext(application: Application) : Context {
        return application
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideApiService(gson : Gson) : ApiService{
        return Retrofit.Builder()
                .baseUrl("https://wger.de")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideExerciseCloudStore(networkManager: NetworkManager) : ExerciseCloudDelegate {
        return ExerciseCloudStore(networkManager)
    }

    @Provides
    @Singleton
    fun provideExerciseLocalStore() : ExerciseDiskDelegate {
        return ExerciseDiskStore()
    }

    @Provides
    @Singleton
    fun provideExerciseRepository(cloudStore: ExerciseCloudStore, diskStore: ExerciseDiskStore) : ExerciseRepository{
        return ExerciseRepository(diskStore, cloudStore)
    }

    @Provides
    fun provideExercisesUseCase(exerciseRepository: ExerciseRepository) : GetExercisesUseCase{
        return GetExercisesUseCase(exerciseRepository)
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(getExercisesUseCase: GetExercisesUseCase) : ViewModelFactory {
        return ViewModelFactory(getExercisesUseCase)
    }

}