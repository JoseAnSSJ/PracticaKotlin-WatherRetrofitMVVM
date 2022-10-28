package com.example.wather.common.data

import com.example.wather.common.entity.WatherForCastEntity
import com.example.wather.common.utils.Constans
import retrofit2.http.GET
import retrofit2.http.Query

interface WatherServices {
    @GET(Constans.ON_CALL_PATH)
    suspend fun getWatherForCastByCoordinates(
        @Query(Constans.LATITUD_PARAM) lat: Double,
        @Query(Constans.LONGIT_PARAM) lon: Double,
        @Query(Constans.APPID_PARAM) appid: String/*,
        @Query(Constans.UNITS_PARAM) units: String,
        @Query(Constans.LANG_PARAM) lang: String*/

    ): WatherForCastEntity

}