package com.example.quiz_japones

import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz_japones.model.RepositorioCaracteres

class QuizActivity : AppCompatActivity() {

    private lateinit var titulo: TextView
    private lateinit var simbolo: TextView
    var perguntaAtual = 0
    var pontuacao = 0
    private var respondendo = false
    private val perguntasDoJogo = RepositorioCaracteres.todosOsCaracteres.shuffled().take(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        titulo = findViewById(R.id.tvTituloQuiz)
        simbolo = findViewById(R.id.tvSimboloQuiz)

        val dificuldade = intent.getIntExtra("dificuldade", 0) // 0 = fácil

        val listener = View.OnClickListener { view ->
            val botaoClicado = view as Button
            val respostaEscolhida = botaoClicado.text.toString()
            verificarResposta(respostaEscolhida, botaoClicado)
        }

        findViewById<Button>(R.id.btnOpcao1).setOnClickListener(listener)
        findViewById<Button>(R.id.btnOpcao2).setOnClickListener(listener)
        findViewById<Button>(R.id.btnOpcao3).setOnClickListener(listener)
        findViewById<Button>(R.id.btnOpcao4).setOnClickListener(listener)


        if (dificuldade == 0) {
            findViewById<Button>(R.id.btnOpcao4).visibility = View.GONE
        } else {
            findViewById<Button>(R.id.btnOpcao4).visibility = View.VISIBLE
        }

        mostrarPergunta()
    }
    private fun mostrarPergunta() {
        // Se acabaram as perguntas, vai para o resultado
        if (perguntaAtual >= perguntasDoJogo.size) {
            finalizarQuiz()
            return
        }

        // Reseta as cores dos botões
        findViewById<Button>(R.id.btnOpcao1).backgroundTintList = null
        findViewById<Button>(R.id.btnOpcao2).backgroundTintList = null
        findViewById<Button>(R.id.btnOpcao3).backgroundTintList = null
        if (findViewById<Button>(R.id.btnOpcao4).visibility == View.VISIBLE) {
            findViewById<Button>(R.id.btnOpcao4).backgroundTintList = null
        }

        val pergunta = perguntasDoJogo[perguntaAtual]

        // Atualiza a tela
        simbolo.text = pergunta.simbolo
        titulo.text = "Questão ${perguntaAtual + 1} de 10"


        // 1. Verifica a visibilidade ANTES de montar a lista
        val btnOpcao4 = findViewById<Button>(R.id.btnOpcao4)
        val modoNormal = btnOpcao4.visibility == View.VISIBLE

        // 2. Cria a quantidade certa de opções
        val listaOpcoes = mutableListOf(pergunta.romaji) // Sempre começa com a certa

        // Adiciona as erradas
        val quantidadeErradas = if (modoNormal) 3 else 2
        while (listaOpcoes.size < quantidadeErradas + 1) {
            val errada = RepositorioCaracteres.todosOsCaracteres.random().romaji
            if (!listaOpcoes.contains(errada)) {
                listaOpcoes.add(errada)
            }
        }

        // 3. Embaralha e distribui
        listaOpcoes.shuffle()

        findViewById<Button>(R.id.btnOpcao1).text = listaOpcoes.removeAt(0)
        findViewById<Button>(R.id.btnOpcao2).text = listaOpcoes.removeAt(0)
        findViewById<Button>(R.id.btnOpcao3).text = listaOpcoes.removeAt(0)

        if (modoNormal) {
            btnOpcao4.text = listaOpcoes.removeAt(0)
        }
    }

    // 5. O que acontece quando o usuário clica
    private fun verificarResposta(respostaEscolhida: String, botaoClicado: Button) {
        if (respondendo) return // Se já estiver respondendo, ignora o clique
        respondendo = true

        val pergunta = perguntasDoJogo[perguntaAtual]

        if (respostaEscolhida == pergunta.romaji) {
            pontuacao++
            val verde = ContextCompat.getColor(this, R.color.verde_correto)
            botaoClicado.backgroundTintList = ColorStateList.valueOf(verde)
        } else {
            val vermelho = ContextCompat.getColor(this, R.color.vermelho_errado)
            botaoClicado.backgroundTintList = ColorStateList.valueOf(vermelho)
        }

        // Espera 1 segundo e executa o que está dentro das chaves
        Handler(Looper.getMainLooper()).postDelayed({
            // Vai para a próxima pergunta
            perguntaAtual++
            respondendo = false
            mostrarPergunta()
        }, 1000)
    }

    // 6. Fim do jogo
    private fun finalizarQuiz() {
        // Mostra um AlertDialog com a pontuação final

        AlertDialog.Builder(this)
            .setTitle("Fim de Jogo!")
            .setMessage("Sua pontuação: $pontuacao de 10")
            .setPositiveButton("Voltar ao Menu") { _, _ ->
                finish() // Fecha a QuizActivity e volta para a tela anterior
            }
            .setCancelable(false) // Impede fechar clicando fora
            .show()
    }
}