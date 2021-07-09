package com.example.galeritutorial.di.module.fragmentbuildersmodule

import com.example.galeritutorial.ui.first.FirstFragment
import com.example.galeritutorial.ui.second.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun contributeSecondFragment(): SecondFragment
}