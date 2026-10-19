package com.example.quiz_japones

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.GridView
import android.widget.ArrayAdapter
import com.example.quiz_japones.model.RepositorioCaracteres

class CaracteresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caracteres)

        val gridView = findViewById<GridView>(R.id.gridViewCaracteres)

        val caracteres = RepositorioCaracteres.todosOsCaracteres.map {
            "${it.simbolo} (${it.romaji})"
        }

        val adapter = ArrayAdapter(
            this,
            R.layout.item_caractere,
            caracteres
        )

        gridView.adapter = adapter
    }
}