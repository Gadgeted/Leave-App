package com.fire1.leaveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class Dialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)


        val btn_show = findViewById<Button>(R.id.btn_show)
        btn_show.setOnClickListener {
            val view = View.inflate(this@Dialog, R.layout.dialog_view, null)

            val btn_confirm = findViewById<Button>(R.id.confirm)

            val builder = AlertDialog.Builder(this@Dialog)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)

            view.setOnClickListener {
                btn_confirm.setOnClickListener {
                    dialog.dismiss()
                }
            }



        }
    }
}