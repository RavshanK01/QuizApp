package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var btn_start:Button
    private lateinit var et_name:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btn_start)
        et_name = findViewById(R.id.et_name)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener{

            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizzQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
                
        }

    }
}