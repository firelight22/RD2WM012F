package com.eni.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Ville::class),version = 2,exportSchema = false)
abstract class AppDatabase :RoomDatabase(){
    //On créé les méthodes abstraites pour les DAO
    abstract fun villeDao(): VilleDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context : Context):AppDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context, AppDatabase::class.java,"villes")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance;
            }
        }
    }
}