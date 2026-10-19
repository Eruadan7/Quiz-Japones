package com.example.quiz_japones.model

object RepositorioCaracteres {

    val todosOsCaracteres = listOf(
        // Vogais (5)
        Caractere("あ", "a", "Vogais"),
        Caractere("い", "i", "Vogais"),
        Caractere("う", "u", "Vogais"),
        Caractere("え", "e", "Vogais"),
        Caractere("お", "o", "Vogais"),

        // K (5)
        Caractere("か", "ka", "K"),
        Caractere("き", "ki", "K"),
        Caractere("く", "ku", "K"),
        Caractere("け", "ke", "K"),
        Caractere("こ", "ko", "K"),

        // S (5)
        Caractere("さ", "sa", "S"),
        Caractere("し", "shi", "S"),
        Caractere("す", "su", "S"),
        Caractere("せ", "se", "S"),
        Caractere("そ", "so", "S"),

        // T (5)
        Caractere("た", "ta", "T"),
        Caractere("ち", "chi", "T"),
        Caractere("つ", "tsu", "T"),
        Caractere("て", "te", "T"),
        Caractere("と", "to", "T"),

        // N (5)
        Caractere("な", "na", "N"),
        Caractere("に", "ni", "N"),
        Caractere("ぬ", "nu", "N"),
        Caractere("ね", "ne", "N"),
        Caractere("の", "no", "N"),

        // H (5)
        Caractere("は", "ha", "H"),
        Caractere("ひ", "hi", "H"),
        Caractere("ふ", "fu", "H"),
        Caractere("へ", "he", "H"),
        Caractere("ほ", "ho", "H"),

        // M (5)
        Caractere("ま", "ma", "M"),
        Caractere("み", "mi", "M"),
        Caractere("む", "mu", "M"),
        Caractere("め", "me", "M"),
        Caractere("も", "mo", "M"),

        // Y (3)
        Caractere("や", "ya", "Y"),
        Caractere("ゆ", "yu", "Y"),
        Caractere("よ", "yo", "Y"),

        // R (5)
        Caractere("ら", "ra", "R"),
        Caractere("り", "ri", "R"),
        Caractere("る", "ru", "R"),
        Caractere("れ", "re", "R"),
        Caractere("ろ", "ro", "R"),

        // W (2) + N final (1)
        Caractere("わ", "wa", "W"),
        Caractere("を", "wo", "W"),
        Caractere("ん", "n", "N final")
    )

    fun getPorGrupo(grupo: String): List<Caractere> {
        return todosOsCaracteres.filter { it.grupo == grupo }
    }
}