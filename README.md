# 🇯🇵 Quiz Japonês - Hiragana

Um aplicativo Android nativo desenvolvido em Kotlin para auxiliar no aprendizado dos caracteres básicos do alfabeto japonês (Hiragana). O app combina uma tela de consulta visual (mapa de caracteres) com um sistema dinâmico de quiz para testar os conhecimentos do usuário.

## 📱 Funcionalidades

*   **Tela Inicial:** Menu central para acessar as diferentes funcionalidades do app.
*   **Mapa de Caracteres (Hiragana):** Visualização de todos os 46 caracteres básicos do Hiragana em um GridView, exibindo o símbolo japonês e sua respectiva leitura (romaji).
*   **Quiz Interativo:**
    *   Seleção de dificuldade via caixa de diálogo (Fácil ou Normal).
    *   Modo **Fácil**: 3 opções de resposta por pergunta.
    *   Modo **Normal**: 4 opções de resposta por pergunta.
    *   Perguntas geradas aleatoriamente a partir do banco de dados do app.
    *   Feedback visual de acerto/erro.

## 🏗️ Arquitetura e Tecnologias

O projeto foi construído utilizando as práticas modernas de desenvolvimento Android:

*   **Linguagem:** Kotlin
*   **UI (User Interface):** XML com `ConstraintLayout` e `GridView`.
*   **Arquitetura:** Separação de responsabilidades (UI e Modelo de Dados).
    *   `data class` para representar a entidade `Caractere`.
    *   Repositório de dados (`object RepositorioCaracteres`) atuando como **Single Source of Truth** (Fonte Única de Verdade) para as telas de consulta e quiz.
*   **Componentes do Android:**
    *   `Activity`: Para navegação entre telas (Main, Caracteres, Quiz).
    *   `DialogFragment` + `AlertDialog`: Para o popup de seleção de dificuldade.
    *   `Intent`: Para passagem de parâmetros (dificuldade escolhida) entre telas.
    *   `ArrayAdapter`: Para o preenchimento do GridView de caracteres.

## 📂 Estrutura de Pastas (Simplificada)

```text
📁 com.example.quiz_japones
  │
  ├── 📁 model
  │     ├── 📄 Caractere.kt               
  │     └── 📄 RepositorioCaracteres.kt   (Os 46 caracteres e filtros)
  │
  ├── 📄 MainActivity.kt                  (Tela de menu)
  ├── 📄 CaracteresActivity.kt            (Tela do mapa de caracteres)
  ├── 📄 QuizActivity.kt                  (Lógica do quiz e controle de estado)
  └── 📄 EscolherDificuldadeFragment.kt   (Popup de seleção)