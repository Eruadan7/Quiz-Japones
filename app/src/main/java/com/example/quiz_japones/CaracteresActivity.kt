package com.example.quiz_japones

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.GridView
import android.widget.ArrayAdapter

class CaracteresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caracteres)

        val gridView = findViewById<GridView>(R.id.gridViewCaracteres)

        //Lista com 10 caracteres
        val caracteres = listOf(
            "あ (a)", "い (i)", "う (u)", "え (e)", "お (o)",
            "か (ka)", "き (ki)", "く (ku)", "け (ke)", "こ (ko)"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.item_caractere,
            caracteres
        )

        gridView.adapter = adapter
    }
}