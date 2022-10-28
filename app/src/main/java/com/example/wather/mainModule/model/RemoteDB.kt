package com.example.wather.mainModule.model

import com.example.wather.common.entity.WatherForCastEntity
import com.example.wather.common.data.WatherServices
import com.example.wather.common.utils.Constans
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDB {
    private val retrofit = Retrofit.Builder().baseUrl(Constans.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(WatherServices::class.java)

    suspend fun getWatherForCastByCoordinates(lat: Double, lon: Double, appid: String, units: String, lang: String): WatherForCastEntity = withContext(Dispatchers.IO){
        //service.getWatherForCastByCoordinates(lat,lon, appid, units, lang)
        service.getWatherForCastByCoordinates(lat,lon, appid)


    }
}