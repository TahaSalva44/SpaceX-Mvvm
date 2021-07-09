package com.example.galeritutorial.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.galeritutorial.di.qualifiers.ViewModelKey
import com.example.galeritutorial.ui.first.FirstViewModel
import com.example.galeritutorial.ui.second.SecondViewModel
import com.example.galeritutorial.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindFirstViewModel(firstViewModel: FirstViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(firstViewModel: SecondViewModel): ViewModel

}