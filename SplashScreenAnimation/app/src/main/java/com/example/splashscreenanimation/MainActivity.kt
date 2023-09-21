package com.example.splashscreenanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lottieView: LottieAnimationView = findViewById(R.id.lottieAnimation)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        Handler(Looper.getMainLooper()).postDelayed(kotlinx.coroutines.Runnable {
                                                                                var i = Intent(this,HomeActivity::class.java)
            startActivity(i)
            finish()
        },2000)

    }
}