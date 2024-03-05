package com.example.signupwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profile_image = findViewById<CircleImageView>(R.id.profile_image)
        val name= findViewById<TextView>(R.id.name)
        val username= findViewById<TextView>(R.id.username)
        val dob= findViewById<TextView>(R.id.dob)
        val phonenumber= findViewById<TextView>(R.id.phonenumber)

        val tvimage = intent.getIntExtra("image",R.drawable.img1)
        val tvname = intent.getStringExtra("name")
        val tvusername = intent.getStringExtra("username")
        val tvdob = intent.getStringExtra("dob")
        val tvphonenumber = intent.getStringExtra("phonenumber")

        profile_image.setImageResource(tvimage)
        name.text = tvname
        username.text=tvusername
        dob.text =tvdob
        phonenumber.text=tvphonenumber

    }
}