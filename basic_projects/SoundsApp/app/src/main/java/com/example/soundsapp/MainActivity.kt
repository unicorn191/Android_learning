package com.example.soundsapp

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var mediaPLayer1:MediaPlayer?  = null
    private lateinit var fb_play:FloatingActionButton
    private lateinit var fb_pause:FloatingActionButton
    private lateinit var fb_stop:FloatingActionButton
    private lateinit var seekBar:SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    private lateinit var tv_played_time:TextView
    private lateinit var tv_due_time:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var main_layout:ConstraintLayout = findViewById(R.id.main)

        val birds_btn: Button = findViewById(R.id.birds_btn)
        val rain_btn: Button = findViewById(R.id.rain_btn)
        val flute_btn: Button = findViewById(R.id.flute_btn)
        var image_view: ImageView = findViewById(R.id.imageView)
        fb_play = findViewById(R.id.fb_play)
        fb_pause = findViewById(R.id.fb_pause)
        fb_stop = findViewById(R.id.fb_stop)
        tv_due_time = findViewById(R.id.tv_due)
        tv_played_time = findViewById(R.id.tv_played)
        seekBar = findViewById(R.id.seekBar)
        handler = Handler(Looper.getMainLooper())

       // main_layout.background.alpha = 100

        birds_btn.setOnClickListener {
            if (mediaPLayer1 != null){
                mediaPlayerStop()
            }

          //  image_view.setImageResource(R.drawable.birds)
            main_layout.setBackgroundResource(R.drawable.birds)
            main_layout.background.alpha = 180


            audioControlsvisibility()
            fb_play.setOnClickListener {
                if (mediaPLayer1 == null) {
                    mediaPLayer1 = MediaPlayer.create(this, R.raw.birds)
                }
                mediaPLayer1?.start()
                initialiseSeekBar()
            }
            fb_pause.setOnClickListener {
                mediaPLayer1?.pause()
            }
            fb_stop.setOnClickListener {
                mediaPlayerStop()
            }
        }
        rain_btn.setOnClickListener {
            if (mediaPLayer1 != null){
                mediaPlayerStop()
            }
          //  image_view.setImageResource(R.drawable.rain)
            main_layout.setBackgroundResource(R.drawable.rain)
            main_layout.background.alpha = 180
            audioControlsvisibility()

            fb_play.setOnClickListener {
                if (mediaPLayer1 == null) {
                    mediaPLayer1 = MediaPlayer.create(this, R.raw.rain)
                }
                mediaPLayer1?.start()
                initialiseSeekBar()
            }
            fb_pause.setOnClickListener {
                mediaPLayer1?.pause()
            }
            fb_stop.setOnClickListener {
                mediaPlayerStop()
            }
        }
        flute_btn.setOnClickListener {
            if (mediaPLayer1 != null){
                mediaPlayerStop()
            }
           // image_view.setImageResource(R.drawable.flute)
            main_layout.setBackgroundResource(R.drawable.flute)
            main_layout.background.alpha = 180

            fb_play.setOnClickListener {
                if (mediaPLayer1 == null) {
                    mediaPLayer1 = MediaPlayer.create(this, R.raw.flute)
                }
                mediaPLayer1?.start()
                initialiseSeekBar()
            }
            fb_pause.setOnClickListener {
                mediaPLayer1?.pause()
            }
            fb_stop.setOnClickListener {
                mediaPlayerStop()
            }
        }

    }

    private fun mediaPlayerStop(){
        mediaPLayer1?.stop()
        mediaPLayer1?.reset()
        mediaPLayer1?.release()
        mediaPLayer1 = null
        seekBar.progress = 0
        handler.removeCallbacks(runnable)
        tv_due_time.text = ""
        tv_played_time.text = ""
    }
    private fun audioControlsvisibility(){
        fb_play.visibility = VISIBLE
        fb_pause.visibility = VISIBLE
        fb_stop.visibility = VISIBLE
        seekBar.visibility = VISIBLE
    }

    private fun initialiseSeekBar(){
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPLayer1?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        seekBar.max = mediaPLayer1!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPLayer1!!.currentPosition

            val duration  = mediaPLayer1!!.duration/1000
            val playedTime = mediaPLayer1!!.currentPosition/1000
            val dueTime = duration - playedTime
            tv_due_time.text = "$dueTime sec"
            tv_played_time.text = "$playedTime sec"

            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }

}