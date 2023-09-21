package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1 = findViewById<Button>(R.id.button_id)
        var e1 = findViewById<EditText>(R.id.editText_id)

        b1.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if(it == TextToSpeech.SUCCESS){
                    tts.language = Locale.ENGLISH
                    tts.setSpeechRate(1.0f)
                    tts.speak(e1.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })
        }

    }
}