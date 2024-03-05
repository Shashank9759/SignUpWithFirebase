package com.example.signupwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.example.signupwithfirebase.LoginScreen.Companion.KEY1

class HomeScreen : AppCompatActivity() {
    lateinit var dataArrayList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val tvname = findViewById<TextView>(R.id.welcome)

        val name = intent.getStringExtra(KEY1)

        tvname.text = "Welcome $name"

        var listview = findViewById<ListView>(R.id.listview)
        var data = getdata()
        listview.adapter = myadapter(this, data)

        listview.setOnItemClickListener { adapterView, view, i, l ->
        // open a new activity
            val image = data[i].img
            val name = data[i].name
            val username = data[i].username
            val dob = data[i].dob
            val phonenumber = data[i].phonenumber


            val i = Intent(this, ProfileActivity::class.java)

            i.putExtra("image", image)
            i.putExtra("name", name)
            i.putExtra("username", username)
            i.putExtra("dob", dob)
            i.putExtra("phonenumber", phonenumber)
            startActivity(i)
        }


    }

    fun getdata(): ArrayList<UserData> {

        return arrayListOf(
            UserData(
                "Shashank", R.drawable.img1, "Sha@142003", "1/4/2003", "9737237487", "Last Seen 4:00 PM"),
            UserData("Angela", R.drawable.img2, "ang98", "23/09/1998", "9848237487", "Last Seen 5:00 AM"),
            UserData("Dhruv", R.drawable.img3, "dh536", "2/02/1999", "9987237487", "Last Seen 4:30 AM"),
            UserData("Luies", R.drawable.img4, "lu987", "8/09/82000", "9737456487", "Last Seen 5:00 PM"),
            UserData("Aman", R.drawable.img5, "am56y", "3/03/1995", "9737236787", "Last Seen 3:50 PM"),
            UserData("Neha", R.drawable.img6, "nrh56g", "12/09/1997", "898737487", "Last Seen 2:34 PM"),
            UserData("John", R.drawable.img7, "joh78k", "23/04/1978", "9737987487", "Last Seen 4:10 AM")


        )
    }
}