package com.fire1.leaveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profile = findViewById<MaterialCardView>(R.id.viewprofile)
        profile.setOnClickListener {
            val profile = Intent(applicationContext, Profile::class.java)
            startActivity(profile)
        }

        val apply = findViewById<MaterialCardView>(R.id.leaveapply)
        apply.setOnClickListener {
            val apply = Intent(applicationContext, FormActivity::class.java)
            startActivity(apply)
        }

    }

}
