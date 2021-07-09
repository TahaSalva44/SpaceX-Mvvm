package com.example.galeritutorial.network.entity

import com.example.galeritutorial.model.Photo
import com.google.gson.annotations.SerializedName

data class PhotoEntity(
    @SerializedName("photos")
    val photos:ArrayList<Photo>
) {

}