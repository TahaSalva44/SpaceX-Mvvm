package com.example.galeritutorial.model


import com.google.gson.annotations.SerializedName

data class Reuse(
    @SerializedName("capsule")
    val capsule: Boolean,
    @SerializedName("core")
    val core: Boolean,
    @SerializedName("fairings")
    val fairings: Boolean,
    @SerializedName("side_core1")
    val sideCore1: Boolean,
    @SerializedName("side_core2")
    val sideCore2: Boolean
)