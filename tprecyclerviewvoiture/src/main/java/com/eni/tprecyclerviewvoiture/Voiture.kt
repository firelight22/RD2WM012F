package com.eni.tprecyclerviewvoiture

enum class Energie{
    ELECTRIC, DIESEL, ESSENCE, GPL, HYDROGENE }

data class Voiture (
    val marque :String,
    val modele: String,
    val energie: Energie,
    val prix: Int,
    val puissance: Int,
)