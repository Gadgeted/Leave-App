package com.fire1.leaveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val application = findViewById<Button>(R.id.application)
        application.setOnClickListener {
            val application = Intent(applicationContext, FormActivity::class.java)
            startActivity(application)
            Toast.makeText(this, "Form Application", Toast.LENGTH_SHORT).show()
        }
    }
}