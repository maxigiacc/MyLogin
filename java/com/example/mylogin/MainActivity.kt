package com.example.mylogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = Firebase.auth
        button = findViewById(R.id.logout)
        textView = findViewById(R.id.user_details)
        user = mAuth.currentUser

        if (user == null) {
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        else
            textView.text = user!!.email

        button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}