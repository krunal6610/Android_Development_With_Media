package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.view.menu.MenuAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var seeekBar: SeekBar
    lateinit var play: FloatingActionButton
    lateinit var pause: FloatingActionButton
    lateinit var stop: FloatingActionButton
    private var mp: MediaPlayer? = null
    private var currentSong = mutableListOf(R.raw.song)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controlSound(currentSong[0])
        
    }

    private fun controlSound(i: Int) {
        play = findViewById(R.id.fab_play)
        pause = findViewById(R.id.fab_pause)
        stop = findViewById(R.id.fab_stop)
        play.setOnClickListener {
            if (mp == null) {
                mp = MediaPlayer.create(this, i)
                Log.d("MainActivity", "i ${mp!!.audioSessionId}")
                initialiseSeekBar()
            }
            mp?.start()
        }
        pause.setOnClickListener {
            if(mp!=null) mp?.pause()
        }
        stop.setOnClickListener {
            if(mp!=null){
                mp?.stop()
                mp?.reset()
                mp?.release()
                mp == null
            }
        }
        seeekBar = findViewById(R.id.seekbar_id)
        seeekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mp?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
    private fun initialiseSeekBar() {
        seeekBar.max = mp!!.duration
        var handler = Handler()
        handler.postDelayed(object:Runnable{
            override fun run() {
                try {
                    seeekBar.progress = mp!!.currentPosition
                    handler.postDelayed(this,1000)
                }
                catch (e:Exception){
                    seeekBar.progress = 0
                }
            }
        })
    }
}

private fun Handler.postDelayed(runnable: Runnable) {

}

