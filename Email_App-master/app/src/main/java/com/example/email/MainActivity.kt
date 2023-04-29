package com.example.email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etEmail :EditText=findViewById(R.id.etMail)
        val etSubject :EditText=findViewById(R.id.etSubject)
        val etMessage :EditText=findViewById(R.id.etMessage)
        val btsend : Button=findViewById(R.id.btSend)
        btsend.setOnClickListener {
            val email= etEmail.text.toString()
            val subject= etSubject.text.toString()
            val message= etMessage.text.toString()
            val intent=Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"Choose a client...!"))
        }
    }
}