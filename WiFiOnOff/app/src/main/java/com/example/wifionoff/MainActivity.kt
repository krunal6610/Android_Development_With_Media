package com.example.wifionoff

import android.annotation.SuppressLint
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnON: Button
    lateinit var btnOff:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnON = findViewById(R.id.btn_ON)
        btnOff = findViewById(R.id.btn_OFF)

        btnON.setOnClickListener {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
                val i = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(i,1)
            }
            else{
                val wifiManage = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
                wifiManage.setWifiEnabled(true)
            }
        }

        btnOff.setOnClickListener {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
                val i = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(i,0)
            }
            else{
                val wifiManage = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
                wifiManage.setWifiEnabled(false)
            }
        }

    }
}