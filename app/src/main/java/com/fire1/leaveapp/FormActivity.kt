package com.fire1.leaveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val radioGroupLeaveType = findViewById<RadioGroup>(R.id.radioGroupLeaveType)
        val datePickerStart = findViewById<DatePicker>(R.id.datePickerStart)
        val datePickerEnd = findViewById<DatePicker>(R.id.datePickerEnd)
        val editTextReason = findViewById<EditText>(R.id.editTextReason)
        val buttonApplyLeave = findViewById<Button>(R.id.buttonApplyLeave)

        buttonApplyLeave.setOnClickListener {

            val selectedLeaveType = when (radioGroupLeaveType.checkedRadioButtonId) {
                R.id.radioButtonSickLeave -> "Sick Leave"
                R.id.radioButtonVacation -> "Vacation"
                R.id.radioButtonMaternity -> "Maternity Leave"
                R.id.radioButtonPaternity -> "Paternity Leave"
                else -> ""
            }
            val startDate = "${datePickerStart.year}-${datePickerStart.month + 1}-${datePickerStart.dayOfMonth}"
            val endDate = "${datePickerEnd.year}-${datePickerEnd.month + 1}-${datePickerEnd.dayOfMonth}"
            val reason = editTextReason.text.toString()

            val applyleave = Intent(applicationContext,Dialog::class.java)
            startActivity(applyleave)

            // You can handle the data (selectedLeaveType, startDate, endDate, reason) here, such as sending it to a server or performing local processing
        }
    }
}