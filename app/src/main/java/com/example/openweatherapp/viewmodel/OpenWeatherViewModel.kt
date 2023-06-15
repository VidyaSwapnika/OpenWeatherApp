package com.example.openweatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openweatherapp.data.OpenWeatherResponse
import com.example.openweatherapp.repository.OpenWeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OpenWeatherViewModel constructor(private val repository: OpenWeatherRepository) : ViewModel() {

    val weatherCityResponse = MutableLiveData<OpenWeatherResponse>()
    val weatherLatLonResponse = MutableLiveData<OpenWeatherResponse>()
    val errorMessage = MutableLiveData<String>()


    fun getWeatherData(city : String) {
        val response = repository.getWeatherDataByCity(city ,"31aeff340ac2452df20a7f2678bacb29")

        response.enqueue( object : Callback<OpenWeatherResponse>{
            override fun onResponse(
                call: Call<OpenWeatherResponse>,
                response: Response<OpenWeatherResponse>
            ) {
                weatherCityResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<OpenWeatherResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }

    fun getCurrentLocationWeatherData(latitude : Double, longitude : Double ) {
        val response = repository.getWeatherDataByLatLon(latitude, longitude, "31aeff340ac2452df20a7f2678bacb29")

        response.enqueue( object : Callback<OpenWeatherResponse>{
            override fun onResponse(
                call: Call<OpenWeatherResponse>,
                response: Response<OpenWeatherResponse>
            ) {
                weatherLatLonResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<OpenWeatherResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}