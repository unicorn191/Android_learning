package com.example.clapping_app

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    private lateinit var duration:TextView
    private lateinit var due_time:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        handler = Handler(Looper.getMainLooper())
        duration = findViewById(R.id.start)
        due_time = findViewById(R.id.due)
        val play_btn:FloatingActionButton = findViewById(R.id.play_btn)
        val pause_btn:FloatingActionButton = findViewById(R.id.floatingActionButton2)
        val stop_btn:FloatingActionButton = findViewById(R.id.floatingActionButton3)

        play_btn.setOnClickListener {
            if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this,R.raw.audio)
                initialiseSeekBar()
            }
            mediaPlayer?.start()
        }

        pause_btn.setOnClickListener {
            mediaPlayer?.pause()
        }

        stop_btn.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
            handler.removeCallbacks(runnable)
            seekBar.progress = 0
            duration.text = ""
            due_time.text = ""
        }
    }

    private fun initialiseSeekBar(){
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })


        seekBar.max = mediaPlayer!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPlayer!!.currentPosition
            val playedTime = mediaPlayer!!.currentPosition/1000
            duration.text = "$playedTime sec"
            val duration = mediaPlayer!!.duration/1000
            val dueTime = duration - playedTime
            due_time.text ="$dueTime sec"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
}