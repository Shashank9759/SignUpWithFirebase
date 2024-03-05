package com.example.signupwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginScreen : AppCompatActivity() {
    lateinit var database:DatabaseReference
    companion object{
        const val KEY1 = "com.example.signupwithfirebase.LoginScreen.KEY1"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)


        val logbtn = findViewById<Button>(R.id.loginbtn2)
        val etUniqueid= findViewById<TextInputEditText>(R.id.uniqueidtv)

        logbtn.setOnClickListener{
            val Uniqueid = etUniqueid.text.toString()

            if(Uniqueid.isNotEmpty()){
                start(Uniqueid)
            }
            else{
                Toast.makeText(this,"Please Enter Your Unique Id",Toast.LENGTH_SHORT).show()
            }

        }
    }


    fun start(Uniqueid: String){
        database = FirebaseDatabase.getInstance().getReference("user")
        database.child(Uniqueid).get().addOnSuccessListener {
            if(it.exists()){
                val name=it.child("name").value.toString()
                val email = it.child("email").value.toString()
                val uniqueid = it.child("uniqueid").value.toString()
                var intent = Intent(this,HomeScreen::class.java)
                intent.putExtra(KEY1,name)
                startActivity(intent)
                finish()

            }

            else{
                Toast.makeText(this,"This Unique Id Doesn't Exists",Toast.LENGTH_SHORT).show()
            }


        }.addOnFailureListener {

            Toast.makeText(this,"Connection Problem",Toast.LENGTH_SHORT).show()

        }

    }
}