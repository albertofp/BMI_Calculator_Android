package br.edu.infnet.calcimc

import android.util.Log
import android.widget.EditText

class Utils {

    //Cria uma nova pessoa com os valores providenciados nos campos altura & peso
    fun addPessoa(pesoText: EditText, alturaText: EditText): Pessoa {
        return Pessoa(
            pesoText.text.toString().toDouble(),
            alturaText.text.toString().toDouble()
        )
    }

    //Confere se os valores nos campos peso e altura nao sao vazios
    fun valCheck(pesoText: EditText,alturaText: EditText):Boolean{
        Log.d("valcheck","${pesoText.text.isNotEmpty() && alturaText.text.isNotEmpty()}")
        return (pesoText.text.isNotEmpty() && alturaText.text.isNotEmpty())
    }
}