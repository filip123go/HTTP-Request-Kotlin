package com.stavros.weather_station

import com.stavros.weather_station.httpRequests.CurrentWeatherRequest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherStationApplication

fun main(args: Array<String>) {
    runApplication<WeatherStationApplication>(*args)
}
