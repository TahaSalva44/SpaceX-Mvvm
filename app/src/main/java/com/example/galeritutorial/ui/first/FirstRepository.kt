package com.example.galeritutorial.ui.first

import com.example.galeritutorial.model.LaunchesEntity
import com.example.galeritutorial.model.Photo
import com.example.galeritutorial.network.ApiService
import com.example.galeritutorial.network.INetworkResponseHandling
import com.example.galeritutorial.network.entity.PhotoEntity
import com.example.galeritutorial.network.helper.DataHolder
import com.example.galeritutorial.network.helper.RequestHelper
import javax.inject.Inject

class FirstRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getLaunches(
        url: String,
        iNetworkResponseHandling: INetworkResponseHandling
    ): DataHolder<LaunchesEntity>? {
        return object : RequestHelper<LaunchesEntity>() {
            override suspend fun createNetworkRequest(): LaunchesEntity {
                return apiService.getLauches(url)
            }

        }.loadRequest(iNetworkResponseHandling, true)
    }
}