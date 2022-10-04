package br.edu.infnet.calcimc

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.infnet.calcimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        var peso     = binding.getPeso
        var altura   = binding.getAltura
        var resultado= binding.mostrarResultado
        var grau     = binding.mostrarGrau

        binding.btnCalc.setOnClickListener{
            viewModel.getBMI(peso,altura,resultado,this,grau)
            peso.setText("")
            altura.setText("")
        }

    }
}