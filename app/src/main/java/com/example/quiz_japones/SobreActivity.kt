package com.example.quiz_japones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz_japones.R
import androidx.compose.ui.res.colorResource

class SobreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Em vez de setContentView(R.layout...), usamos setContent
        setContent {
            MaterialTheme {
                TelaSobre()
            }
        }
    }
}

@Preview
@Composable
fun TelaSobre() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = androidx.cardview.R.color.cardview_light_background))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sobre o Quiz Japonês",
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Este aplicativo foi criado para ajudar no aprendizado do alfabeto japonês (Hiragana).\n\nDesenvolvido com Kotlin e Compose.",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}