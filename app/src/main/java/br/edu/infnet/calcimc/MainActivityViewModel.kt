package br.edu.infnet.calcimc

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode

class MainActivityViewModel {
    lateinit var pessoa:Pessoa
    private  val utils = Utils()

    fun getBMI(
        peso:       EditText,
        altura:     EditText,
        resultado:  TextView,
        context:    Context,
        degree:     TextView
    ){
        val check:Boolean = utils.valCheck(peso,altura)
        //Exibe mensagem de erro caso campo(s) em branco
        if(!(check)){
            Toast.makeText(
                context, "Preencher campos", Toast.LENGTH_SHORT
            ).show()
        }
        //Se validado com exito, calcula e exibe IMC
        else{
            pessoa  = utils.addPessoa(peso,altura)
            //Calcula o IMC/BMI da pessoa
            pessoa.calcBMI(pessoa,pessoa.peso,pessoa.altura)
            if(pessoa.altura > 0) {
                resultado.text =
                    "Seu IMC: ${pessoa.BMI.toBigDecimal().setScale(1, RoundingMode.HALF_UP)}.\n" +
                            "Grau de obesidade:\n "
                degree.text = "${calcObesidade(pessoa.BMI)}"
            }
            else{
                resultado.text = "ERRO: Altura deve ser maior que 0"
                degree.text    = ""
            }


        }
    }
    fun calcObesidade(bmi:Double):String{
        return when{
            bmi < 16.0 -> "Magreza grave"
            bmi < 17.0 -> "Magreza moderada"
            bmi < 18.5 -> "Magreza leve"
            bmi < 25.0 -> "Saudável"
            bmi < 30.0 -> "Sobrepeso"
            bmi < 35.0 -> "Obesidade Grau I"
            bmi <= 40.0 -> "Obesidade Grau II (Severa)"
            bmi > 40.0 -> "Obesidade Grau III (Mórbida)"
            else -> ""
        }
    }
}