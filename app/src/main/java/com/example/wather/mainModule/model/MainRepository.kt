package com.example.wather.mainModule.model

import com.example.wather.common.entity.WatherForCastEntity

class MainRepository {
    private val remoteDB = RemoteDB()

    suspend fun getWatherAndForCast(lat: Double, lon: Double, appid: String, units: String, lang: String) : WatherForCastEntity
    = remoteDB.getWatherForCastByCoordinates(lat, lon, appid, units, lang)
}