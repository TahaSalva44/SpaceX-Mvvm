package com.example.galeritutorial.model


import com.google.gson.annotations.SerializedName

data class LaunchesEntityItem(
    @SerializedName("crew")
    val crew: Any,
    @SerializedName("details")
    val details: String,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("is_tentative")
    val isTentative: Boolean,
    @SerializedName("launch_date_local")
    val launchDateLocal: String,
    @SerializedName("launch_date_unix")
    val launchDateUnix: Int,
    @SerializedName("launch_date_utc")
    val launchDateUtc: String,
    @SerializedName("launch_site")
    val launchSite: LaunchSite,
    @SerializedName("launch_success")
    val launchSuccess: Boolean,
    @SerializedName("launch_window")
    val launchWindow: Int,
    @SerializedName("launch_year")
    val launchYear: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("mission_id")
    val missionId: List<String>,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("reuse")
    val reuse: Reuse,
    @SerializedName("rocket")
    val rocket: Rocket,
    @SerializedName("ships")
    val ships: List<String>,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Int,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String,
    @SerializedName("tbd")
    val tbd: Boolean,
    @SerializedName("telemetry")
    val telemetry: Telemetry,
    @SerializedName("tentative_max_precision")
    val tentativeMaxPrecision: String,
    @SerializedName("timeline")
    val timeline: Timeline,
    @SerializedName("upcoming")
    val upcoming: Boolean
)