package com.example.galeritutorial.network

import com.example.galeritutorial.model.Comments
import com.example.galeritutorial.model.LaunchesEntity
import com.example.galeritutorial.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getLauches(@Url url:String):LaunchesEntity


}