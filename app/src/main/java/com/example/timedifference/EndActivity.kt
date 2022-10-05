package com.example.timedifference

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.TimePicker

class EndActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val pickerEnd = findViewById(R.id.timePickerEnd) as TimePicker
        pickerEnd.setIs24HourView(true)

        pickerEnd.setHour(MyApplication.Companion.g_hour_end)
        pickerEnd.setMinute(MyApplication.Companion.g_min_end)

        pickerEnd.setOnTimeChangedListener(TimePicker.OnTimeChangedListener { view, hourOfDay, minute ->
            MyApplication.Companion.g_hour_end = hourOfDay
            MyApplication.Companion.g_min_end =minute

        })

        // Enables Always-on
        setAmbientEnabled()
    }
}
