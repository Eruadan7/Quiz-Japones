package com.example.quiz_japones

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        val dificuldade = intent.getIntExtra("dificuldade", 0) // 0 = fácil

        val texto = findViewById<TextView>(R.id.tvTesteDificuldade)

        if (dificuldade == 0) {
            texto.text = "Dificuldade: Fácil"
        } else {
            texto.text = "Dificuldade: Normal"
        }
    }
}