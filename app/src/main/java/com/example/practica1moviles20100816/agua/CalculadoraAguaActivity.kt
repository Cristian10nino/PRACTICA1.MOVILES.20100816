package com.example.practica1moviles20100816.agua




import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.practica1moviles20100816.R

import com.example.practica1moviles20100816.databinding.ActivityCalculadoraAguaBinding
import com.example.practica1moviles20100816.utils.Validaciones
import com.example.practica1moviles20100816.utils.Calculos

class CalculadoraAguaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraAguaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraAguaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val pesoStr = binding.etPeso.text.toString().trim()
            val generoFactor = when (binding.rgGenero.checkedRadioButtonId) {
                R.id.rbMasculino -> 1.02
                R.id.rbFemenino -> 1.01
                R.id.rbOtro -> 1.00
                else -> null
            }

            if (!Validaciones.validarCamposAgua(nombre, pesoStr, generoFactor, this)) return@setOnClickListener

            val litros = Calculos.calcularAgua(pesoStr.toFloat(), generoFactor!!)
            val resultado = "$nombre debe beber aproximadamente %.2f litros de agua al día".format(litros)
            binding.tvResultado.text = resultado
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}
