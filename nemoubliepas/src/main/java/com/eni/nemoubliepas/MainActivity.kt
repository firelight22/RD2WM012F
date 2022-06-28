package com.eni.nemoubliepas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.eni.nemoubliepas.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class MainActivity : AppCompatActivity() {
    lateinit var amb : ActivityMainBinding
    lateinit var tel : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1ere solution(générique)
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //2nde solution adapté au binding
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        amb.button.setOnClickListener{
            tel = amb.editTextPhone.text.toString()
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.SEND_SMS),
                22
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 22 && grantResults[0] == PERMISSION_GRANTED){
            val intentSms : Intent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("smsto:$tel")
            )
            intentSms.putExtra("sms_body","Hello, donne moi de l'argent")
            startActivity(intentSms)
        }
    }
}