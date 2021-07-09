package com.example.galeritutorial.ui.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galeritutorial.BuildConfig
import com.example.galeritutorial.base.BaseViewModel
import com.example.galeritutorial.model.LaunchesEntity
import com.example.galeritutorial.model.LaunchesEntityItem
import com.example.galeritutorial.model.Photo
import com.example.galeritutorial.network.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstViewModel @Inject constructor(private val firstRepository: FirstRepository) :
    BaseViewModel() {

    val year = "2014"
    val baseUrl = BuildConfig.BASE_URL
    val launchesEntity: MutableLiveData<ArrayList<LaunchesEntityItem>> = MutableLiveData()


    fun getLaunches() {
        viewModelScope.launch {
            val response = firstRepository.getLaunches(launchesUrl(year), this@FirstViewModel)

            response.let { response ->
                if (response is DataHolder.Success) {
                    launchesEntity.postValue(response.body)
                }
            }
        }
    }

    fun getLaunches(year: Int) {
        viewModelScope.launch {
            val response =
                firstRepository.getLaunches(launchesUrl(year.toString()), this@FirstViewModel)

            response.let { response ->
                if (response is DataHolder.Success) {
                    launchesEntity.postValue(response.body)
                }
            }
        }
    }

    private fun launchesUrl(year: String): String {
        return baseUrl + "launches?launch_year=$year"
    }


}
