package com.eni.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompteurViewModel : ViewModel(){
    val compteur = MutableLiveData<Int>()

    init {
        compteur.value = 0
    }

    fun increment(){
        //compteur++
        compteur.value = compteur.value?.plus(1)
    }

    fun decrement(){
        //compteur++
        compteur.value = compteur.value?.minus(1)
    }
}