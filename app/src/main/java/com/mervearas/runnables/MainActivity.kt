package com.mervearas.runnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start (view:View) {

       number = 0
        runnable = object : Runnable {    //runable initialize
            override fun run() {
                number = number + 1
                textView.text = "Time: $number"
                handler.postDelayed(this,1000) // 1 sn bekletip işlem yapmaya devam etmeyi sağlar
            }
        }
        handler.post(runnable)
    }

    fun stop(view:View){

        handler.removeCallbacks(runnable) //runnable'ı siler
        number=0
        textView.text = "Time: $number"
    }
}