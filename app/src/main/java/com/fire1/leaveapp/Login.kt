package com.fire1.leaveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fire1.leaveapp.constants.Constants
import com.fire1.leaveapp.helpers.ApiHelper
import org.json.JSONArray
import org.json.JSONObject

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


            val editTextEmail : EditText = findViewById(R.id.email)
            val editTextPassword: EditText = findViewById(R.id.password)

            val email = editTextEmail.text
            val password = editTextPassword.text

            val loginButton : Button = findViewById(R.id.loginBtn)
            loginButton.setOnClickListener{
                Toast.makeText(this, "Chill A Minute ☝", Toast.LENGTH_SHORT).show()

                val api: String = Constants.BASE_URL + "/employee/signin"
                val body = JSONObject()
                body.put("email", email.toString())
                body.put("password", password.toString())

                val helper = ApiHelper(applicationContext)
                helper.post(api, body, object : ApiHelper.CallBack{
                    override fun onSuccess(result: JSONArray?) {
                        TODO("Not yet implemented")
                    }

                    override fun onSuccess(result: JSONObject?) {
                        // successful
                        if(result!!.has("accessToken")){

                            Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(result: String?) {
                        Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                    }
                })





            }


    }
}