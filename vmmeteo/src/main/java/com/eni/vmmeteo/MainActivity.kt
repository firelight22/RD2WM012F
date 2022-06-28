package com.eni.vmmeteo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.eni.vmmeteo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var db : ActivityMainBinding
    lateinit var viewModel: MeteoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //db = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(db.root)
        viewModel = ViewModelProvider(this)[MeteoViewModel::class.java]
        db.vm = viewModel
    }
}