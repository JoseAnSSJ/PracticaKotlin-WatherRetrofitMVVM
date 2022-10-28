package com.example.wather.mainModule.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wather.R
import com.example.wather.common.entity.WatherForCastEntity
import com.example.wather.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {
    private val repository = MainRepository()

    private val result = MutableLiveData<WatherForCastEntity>()

    fun getResult(): LiveData<WatherForCastEntity> = result

    private val snakBarMessage = MutableLiveData<Int>()

    fun getSnackBarMessage() = snakBarMessage

    private val loaded = MutableLiveData<Boolean>()

    fun isLoaded() = loaded

    suspend fun getWatherAndForCast(lat: Double, lon: Double, appid: String, units: String, lang: String){
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = repository.getWatherAndForCast(lat, lon, appid, units, lang)
                Log.e("prueba", resultServer.toString())
                result.value = resultServer
            } catch (e: Exception) {
                Log.e("prueba", e.message.toString())
                snakBarMessage.value = R.string.main_error_server
            } finally {
                loaded.value = true
            }
        }
    }
}