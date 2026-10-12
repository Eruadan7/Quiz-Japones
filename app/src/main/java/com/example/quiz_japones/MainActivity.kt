package com.example.quiz_japones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnIniciar)
            .setOnClickListener {
                EscolherDificuldadeFragment{ escolha ->
                    val dificuldade = if (escolha == 0) 0 else 1
                    val intentQuiz = Intent(this, QuizActivity::class.java)
                    intentQuiz.putExtra("dificuldade", dificuldade)
                    startActivity(intentQuiz)
                }.show(supportFragmentManager, "GAME_DIALOG")
            }

        val intentCaracteres = Intent(this, CaracteresActivity::class.java)

        findViewById<Button>(R.id.btnCaracteres)
            .setOnClickListener {
                startActivity(intentCaracteres)
            }
    }
}