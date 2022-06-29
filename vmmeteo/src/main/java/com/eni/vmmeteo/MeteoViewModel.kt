package com.eni.vmmeteo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.random.Random

class MeteoViewModel : ViewModel() {
    var temperature = MutableLiveData<Float>()
    var ville = MutableLiveData<String>()
    var vitesseVent = MutableLiveData<Float>()
    var temps = MutableLiveData<String>()

    init {
        ville.value = "Chartres de Bretagne"
        temperature.value = 24.5f
        vitesseVent.value = 8.5f
        temps.value = "Ensoleillé"
    }
    fun changeCity(ville :String){
        this.ville.value = ville
    }
    //"2022-06-05T22:09:15Z"
    var coucherSoleil = Calendar.getInstance().getTime();

    fun coucherSoleilHM() : String{
        return  coucherSoleil.hours.toString()+
                ":" +
                coucherSoleil.minutes.toString()
    }

    fun updateWeather(){
        temperature.value = Random.nextDouble(0.0,150.0).toFloat()
        vitesseVent.value = Random.nextDouble(0.0,250.0).toFloat()
        temps.value = listOf<String>("Ensoleillé", "Pluvieux","Neige").random()
    }

}