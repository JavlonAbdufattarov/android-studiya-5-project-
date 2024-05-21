package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.button)
        mediaPlayer = MediaPlayer.create(this, R.raw.sample3s) // Замените your_sound_file на имя вашего файла

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            } else {
                mediaPlayer.start()
            }
        }
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }
}