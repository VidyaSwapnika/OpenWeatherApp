package com.example.openweatherapp.service

import com.example.openweatherapp.data.OpenWeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("data/2.5/weather")
    fun getWeatherDataByLatLon(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("APPID") appid: String) : Call<OpenWeatherResponse>

    @GET("data/2.5//weather")
    fun getWeatherDataByCity(@Query("q") q: String, @Query("APPID") appid: String) : Call<OpenWeatherResponse>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}