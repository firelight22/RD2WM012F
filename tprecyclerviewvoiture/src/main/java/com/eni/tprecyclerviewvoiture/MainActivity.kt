package com.eni.tprecyclerviewvoiture

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayListVoiture = ArrayList<Voiture>()
        arrayListVoiture.add(Voiture("Tesla","Model S",Energie.ELECTRIC,105000,500))
        arrayListVoiture.add(Voiture("Tesla","Model 3",Energie.ELECTRIC,50000,250))
        arrayListVoiture.add(Voiture("Tesla","Model Y",Energie.ELECTRIC,60000,250))
        arrayListVoiture.add(Voiture("Hyundai","Ioniq",Energie.ELECTRIC,15000,250))
        arrayListVoiture.add(Voiture("Hyundai","Ioniq 6",Energie.ELECTRIC,50000,350))
        arrayListVoiture.add(Voiture("BMW","320",Energie.ESSENCE,50000,150))

        val rvVoiture = findViewById<RecyclerView>(R.id.recyclerViewVoiture)
        val adapter = VoitureAdapter(arrayListVoiture, VoitureAdapter.OnVoitureClickListener {
            Toast.makeText(this, it.modele, Toast.LENGTH_SHORT).show()


        })
        rvVoiture.layoutManager = LinearLayoutManager(this)
        rvVoiture.adapter = adapter


    }
}