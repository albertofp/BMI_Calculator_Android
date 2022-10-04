package br.edu.infnet.calcimc

import android.widget.Toast
import java.lang.Exception
import kotlin.math.pow

data class Pessoa(var peso:Double, var altura:Double){
    var BMI = 0.0

    //Calcula e retorna o BMI(IMC) da pessoa
    fun calcBMI(pessoa:Pessoa, peso: Double, altura:Double): Pessoa {
        altura.toString().toDouble()
        peso.toString().toDouble()
        // fator 10**4 para adaptar a formula de metros para centimetros
           if(altura>0){
                BMI = 100* 100 * peso / altura.pow(2)
           }
        pessoa.BMI = BMI
        return pessoa
    }
}
