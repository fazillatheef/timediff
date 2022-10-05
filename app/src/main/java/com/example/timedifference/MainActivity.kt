package com.example.timedifference

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View

//import android.R
import android.widget.TimePicker
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
//import android.util.Log
//private val TAG = "MainActivity"

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Log.d(TAG,"onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApplication.Companion.g_hour_start =0
        MyApplication.Companion.g_min_start = 0
        MyApplication.Companion.g_hour_end =0
        MyApplication.Companion.g_min_end = 0

        val btnStart = findViewById(R.id.btnStartActivity) as Button
        btnStart.setOnClickListener{
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, StartActivity::class.java)
            startActivity(intent)
        }


        val btnEnd = findViewById(R.id.btnEndActivity) as Button
        btnEnd.setOnClickListener{
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, EndActivity::class.java)
            startActivity(intent)
        }
        // Enables Always-on
        setAmbientEnabled()
    }

    override fun onResume() {
        //Log.d(TAG,"onResume: called")
        super.onResume();
        val btnStart = findViewById(R.id.btnStartActivity) as Button
        val btnEnd = findViewById(R.id.btnEndActivity) as Button
        val txtCalc = findViewById(R.id.txtResult) as TextView
        val StartHour = MyApplication.Companion.g_hour_start
        val StartMin = MyApplication.Companion.g_min_start
        val EndHour = MyApplication.Companion.g_hour_end
        val EndMin = MyApplication.Companion.g_min_end
        val DifferenceMinutes : Int
        val DiffHour : Int
        val DiffMin : Int

        if (StartHour + StartMin !=  0 ) {
            btnStart.text =
                StartHour.toString().padStart(2,'0') + ":" + StartMin.toString().padStart(2,'0')

        }

        if (EndHour + EndMin !=  0 ) {
            btnEnd.text =
                EndHour.toString().padStart(2,'0') + ":" + EndMin.toString().padStart(2,'0')

        }
        if (StartHour + StartMin !=  0 &&
            EndHour + EndMin !=  0 ){
            //txtCalc.textSize = 20f
            var TotalStartMinutes = StartHour * 60 + StartMin
            var TotalEndMinutes = EndHour * 60 + EndMin
            if(TotalEndMinutes> TotalStartMinutes) {
                DifferenceMinutes = TotalEndMinutes - TotalStartMinutes
            }else{
                DifferenceMinutes = TotalStartMinutes - TotalEndMinutes
            }
            DiffHour = DifferenceMinutes / 60
            DiffMin = DifferenceMinutes % 60

            if (DiffHour == 0 && DiffMin == 0){
                txtCalc.text = "No Difference!!"
            }else if (DiffHour == 0){
                txtCalc.text = "$DiffMin m"
            } else if(DiffMin == 0){
                txtCalc.text = "$DiffHour h"
            } else{
                txtCalc.text = "$DiffHour h and $DiffMin m"
            }
        }
    }
}
