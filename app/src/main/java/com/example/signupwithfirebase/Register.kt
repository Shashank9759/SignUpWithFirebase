package com.example.signupwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btn = findViewById<Button>(R.id.btn)
        val etname = findViewById<TextInputEditText>(R.id.nametv)
        val etemail = findViewById<TextInputEditText>(R.id.emailtv)
        val etpassword = findViewById<TextInputEditText>(R.id.passwordtv)
        val etuniqeid = findViewById<TextInputEditText>(R.id.uniqueidtv)
        val loginbtn = findViewById<Button>(R.id.loginbtn)




        btn.setOnClickListener{

            val name = etname.text.toString()
            val email = etemail.text.toString()
            val password = etpassword.text.toString()
            val uniqueid = etuniqeid.text.toString()

            val user = Information(name,email,password,uniqueid)
            database= FirebaseDatabase.getInstance().getReference("user")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }
        }

       loginbtn.setOnClickListener{

           intent = Intent(this@Register,LoginScreen::class.java)
           startActivity(intent)
           finish()
       }

    }
}