package com.eni.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ville(@PrimaryKey(autoGenerate = true)var id:Long = 0L,
                 var population: Int = 0,
                 val moyenneAge:Int = 50,
                 val dateCreation:Int = 1000) {
}