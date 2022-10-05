package com.example.timedifference

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.TimePicker
import android.widget.NumberPicker
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T







class StartActivity : WearableActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val pickerStart = findViewById(R.id.timePickerStart) as TimePicker

        pickerStart.setIs24HourView(true)
        pickerStart.setHour(MyApplication.Companion.g_hour_start)
        pickerStart.setMinute(MyApplication.Companion.g_min_start)

        pickerStart.setOnTimeChangedListener(TimePicker.OnTimeChangedListener { view, hourOfDay, minute ->
            MyApplication.Companion.g_hour_start = hourOfDay
            MyApplication.Companion.g_min_start =minute

        })

        // Enables Always-on
        setAmbientEnabled()
    }
    override fun onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed()
        finish()
    }
}
