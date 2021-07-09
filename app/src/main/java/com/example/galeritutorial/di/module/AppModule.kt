package com.example.galeritutorial.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room

import com.example.galeritutorial.BuildConfig
import com.example.galeritutorial.di.qualifiers.BaseUrlQualifier
import com.example.galeritutorial.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @AppScope
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    @BaseUrlQualifier
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

}