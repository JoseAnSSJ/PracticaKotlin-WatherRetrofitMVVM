package com.example.wather.common.utils

import com.example.wather.common.entity.Weather
import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {

    fun getHour(epoch: Long): String = getFormatedTime(epoch, "HH:mm")

    private fun getFormatedTime(epoch: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch * 1000)

    }


    fun getWeatherMain(weather: List<Weather>?): String{
        return if(weather != null && weather.isNotEmpty()) weather[0].main else "-"
    }
    fun getWeatherDescipcion(weather: List<Weather>?): String{
        return if(weather != null && weather.isNotEmpty()) weather[0].description else "-"
    }
}