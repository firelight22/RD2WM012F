package com.eni.tpapifruit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestBanana = Request.Builder().url(
            "https://www.fruityvice.com/api/fruit/61").build()
        val client = OkHttpClient()

        client.newCall(requestBanana).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "onFailure: " +e.message )
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.code != 200){
                    Log.e(TAG, "onResponse: " + response.code )
                    return
                }

                val responseString = response.body?.string()
                val fruitJson = JSONObject(responseString)
                val nameFruit = fruitJson.getString("name")
                runOnUiThread {
                    Toast.makeText(this@MainActivity,
                        nameFruit,
                        Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}