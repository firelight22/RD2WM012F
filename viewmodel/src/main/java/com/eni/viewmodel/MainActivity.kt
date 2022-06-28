package com.eni.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eni.viewmodel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CompteurViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Affiche le layout & permet de récupérer le Binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //Récupère l'instance du ViewModel de type CompteurViewModel
        viewModel = ViewModelProvider(this)[CompteurViewModel::class.java]

        viewModel.compteur.observe(this, Observer {
            binding.textViewCompteur.text = it.toString()
        })

        //On affiche la valeur du compteur dans le textView
        binding.vm = viewModel

        binding.floatingActionButton.setOnClickListener {
            //On incrémente le compteur
            viewModel.increment()
            //On affiche la valeur du compteur dans le textView
            //binding.vm = viewModel
        }
        binding.floatingActionButtonDecrement.setOnClickListener {
            viewModel.decrement()
        }
    }
}








