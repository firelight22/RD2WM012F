package com.eni.appelapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val requestLuke = Request.Builder()
            .url("https://swapi.dev/api/people/1").build()

        val client = OkHttpClient()
        client.newCall(requestLuke).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //Le serveur n'a jamais répondu
                Log.e(TAG, "onFailure: " + e.message )
            }

            override fun onResponse(call: Call, response: Response) {
                //Le serveur a répondu
                if(response.code == 200){
                    runOnUiThread {
                        val body = response.body
                        val lukeJson = JSONObject(body?.string())
                        val nomLuke = lukeJson.getString("name")
                        Toast.makeText(
                            this@MainActivity,
                            nomLuke,
                            Toast.LENGTH_LONG).show()

                    }
                }

                else
                    Log.e(TAG, "onResponse: " + response.message )
            }
        })


    }
}