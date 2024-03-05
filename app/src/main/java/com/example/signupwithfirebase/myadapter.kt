package com.example.signupwithfirebase

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class myadapter(val context:Activity,val list:ArrayList<UserData>) :ArrayAdapter<UserData>(context,R.layout.itemview,list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view= inflater.inflate(R.layout.itemview,null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name= view.findViewById<TextView>(R.id.name)
        val username= view.findViewById<TextView>(R.id.username)
        val lastOnline= view.findViewById<TextView>(R.id.lastOnline)

        image.setImageResource(list[position].img)
        name.text= list[position].name
        username.text= list[position].username
        lastOnline.text= list[position].lastOnline



        return view
    }
}