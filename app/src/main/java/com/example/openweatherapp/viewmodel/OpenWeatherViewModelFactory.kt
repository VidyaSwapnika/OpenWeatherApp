package com.example.openweatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.openweatherapp.repository.OpenWeatherRepository

class OpenWeatherViewModelFactory constructor(private val repository: OpenWeatherRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(OpenWeatherViewModel::class.java)) {
            OpenWeatherViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}