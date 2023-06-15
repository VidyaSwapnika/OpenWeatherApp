package com.example.openweatherapp.repository

import com.example.openweatherapp.service.RetrofitService

class OpenWeatherRepository constructor(private val retrofitService: RetrofitService) {

    fun getWeatherDataByLatLon(lat: Double, lon: Double, appId: String) =
        retrofitService.getWeatherDataByLatLon(lat, lon, appId)

    fun getWeatherDataByCity(q : String, appId: String) =
        retrofitService.getWeatherDataByCity(q, appId)

}