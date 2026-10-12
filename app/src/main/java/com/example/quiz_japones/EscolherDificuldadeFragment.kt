package com.example.quiz_japones

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class EscolherDificuldadeFragment(
    private val onEscolha: (Int) -> Unit)
    : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Escolha a Dificuldade:")
                .setItems(arrayOf("Fácil", "Normal")) { _, which ->
                    onEscolha(which)
                    dismiss()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}