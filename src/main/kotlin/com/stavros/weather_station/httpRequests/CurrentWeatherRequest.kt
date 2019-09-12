package com.stavros.weather_station.httpRequests

import com.google.gson.GsonBuilder
import com.stavros.weather_station.model.CurrentWeatherModel
import okhttp3.*
import java.io.IOException

open class CurrentWeatherRequest {

    fun fetchJson() {
        println("Atempting to fetch JSON")

        val url = "https://community-open-weather-map.p.rapidapi.com/weather?callback=test&id=2172797&units=metric&mode=xml%2C%20html&q=athens"

        val request = Request.Builder()
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "f7c952bedfmsh155a47f836bd456p167e87jsn9c611ae79742")
                .url(url)
                .get()
                .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                var body = response.body?.string()
                body = body?.replace("test(", "")
                body = body?.replace(")", "")

                val gson = GsonBuilder().create()

                val responseGson = gson.fromJson(body, CurrentWeatherModel::class.java)
                println("Current temp in ${responseGson.name}" +
                        "is ${responseGson.main.temp} Celsius")
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}