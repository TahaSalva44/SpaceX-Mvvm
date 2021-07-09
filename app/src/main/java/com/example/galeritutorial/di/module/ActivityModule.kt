package com.example.galeritutorial.di.module

import com.example.galeritutorial.MainActivity
import com.example.galeritutorial.di.module.fragmentbuildersmodule.MainFragmentBuildersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): MainActivity
}