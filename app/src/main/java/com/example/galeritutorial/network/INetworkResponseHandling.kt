package com.example.galeritutorial.network

interface INetworkResponseHandling {
    fun loading(switch: Boolean)
    fun onGenericErrorTaken(message: String)
    fun onErrorPopUp(header: String, body: String)
}