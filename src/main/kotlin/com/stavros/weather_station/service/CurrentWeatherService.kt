package com.stavros.weather_station.service

import com.stavros.weather_station.httpRequests.CurrentWeatherRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class CurrentWeatherService {

    @Autowired
    lateinit var currentWeatherRequest: CurrentWeatherRequest

    @GetMapping("/{city}")
    fun returnCurrentWeatherInfo(@PathVariable city: String): String? {
        return currentWeatherRequest.fetchCurrentWeather(city)
    }


}