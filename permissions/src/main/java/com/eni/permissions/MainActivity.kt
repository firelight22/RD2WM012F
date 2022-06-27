package com.eni.permissions

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Demande la peermission d'appeler un numéro de téléphone
        //Avec le code de retour 54
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CALL_PHONE),
            54)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Vérifie que l'appel à cette méthode est bien le résultat de la demande 54
        //et que le permission a été accordée
        if(requestCode==54 && grantResults[0] == PERMISSION_GRANTED ){
            //Passer mon appel téléphonique
            val intentCall911 = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
            startActivity(intentCall911)
        }
    }
}