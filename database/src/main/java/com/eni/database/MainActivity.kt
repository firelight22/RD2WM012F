package com.eni.database

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database : AppDatabase = AppDatabase.getInstance(this)
        thread {
            database.villeDao().insert(Ville(0,300000,"Rennes",45,-500))
        }
    }
}