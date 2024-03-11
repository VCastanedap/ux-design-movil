package com.victor.coolcamara

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class home : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val textView = findViewById<TextView>(R.id.gameclok)
        val typeface = ResourcesCompat.getFont(this, R.font.audiowide)
        textView.typeface = typeface

        val btn1 = findViewById<RelativeLayout>(R.id.btn1)

        btn1.setOnClickListener {
            // Crear una intención para navegar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val btn2 = findViewById<RelativeLayout>(R.id.btn2)
        btn2.setOnClickListener {
            // Crear una intención para navegar a MainActivity
            val intent = Intent(this, Nueva_Alarma::class.java)
            startActivity(intent)
        }

        val btn3 = findViewById<RelativeLayout>(R.id.btn3)
        btn3.setOnClickListener {
            // Crear una intención para navegar a MainActivity
            val intent = Intent(this, puzzles::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}