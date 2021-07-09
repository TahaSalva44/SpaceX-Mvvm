package com.example.galeritutorial.model


import com.google.gson.annotations.SerializedName

data class Timeline(
    @SerializedName("dragon_bay_door_deploy")
    val dragonBayDoorDeploy: Int,
    @SerializedName("dragon_separation")
    val dragonSeparation: Int,
    @SerializedName("dragon_solar_deploy")
    val dragonSolarDeploy: Int,
    @SerializedName("engine_chill")
    val engineChill: Int,
    @SerializedName("go_for_launch")
    val goForLaunch: Int,
    @SerializedName("go_for_prop_loading")
    val goForPropLoading: Int,
    @SerializedName("ignition")
    val ignition: Int,
    @SerializedName("liftoff")
    val liftoff: Int,
    @SerializedName("maxq")
    val maxq: Int,
    @SerializedName("meco")
    val meco: Int,
    @SerializedName("prelaunch_checks")
    val prelaunchChecks: Int,
    @SerializedName("propellant_pressurization")
    val propellantPressurization: Int,
    @SerializedName("rp1_loading")
    val rp1Loading: Int,
    @SerializedName("seco-1")
    val seco1: Int,
    @SerializedName("second_stage_ignition")
    val secondStageIgnition: Int,
    @SerializedName("stage1_lox_loading")
    val stage1LoxLoading: Int,
    @SerializedName("stage2_lox_loading")
    val stage2LoxLoading: Int,
    @SerializedName("stage_sep")
    val stageSep: Int,
    @SerializedName("webcast_liftoff")
    val webcastLiftoff: Int
)