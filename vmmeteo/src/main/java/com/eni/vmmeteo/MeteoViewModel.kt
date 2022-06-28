package com.eni.vmmeteo

import androidx.lifecycle.ViewModel
import java.util.*

class MeteoViewModel : ViewModel() {
    var temperature = 24.5f
    var ville = "Chartres de Bretagne"
    var vitesseVent = 8.5f
    var temps = "Ca va"

    //"2022-06-05T22:09:15Z"
    var coucherSoleil = Calendar.getInstance().getTime();

    fun coucherSoleilHM() : String{
        return  coucherSoleil.hours.toString()+
                ":" +
                coucherSoleil.minutes.toString()
    }
}