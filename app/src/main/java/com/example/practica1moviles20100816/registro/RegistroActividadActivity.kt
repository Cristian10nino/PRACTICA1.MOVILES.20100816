package com.example.practica1moviles20100816.registro
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1moviles20100816.databinding.ActivityRegistroActividadBinding

import com.example.practica1moviles20100816.utils.Validaciones
import com.example.practica1moviles20100816.utils.Calculos

class RegistroActividadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroActividadBinding

    private val actividades = listOf("Correr", "Caminar", "Nadar", "Ciclismo", "Yoga")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, actividades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerActividad.adapter = adapter

        binding.btnCalcular.setOnClickListener {
            val actividad = binding.spinnerActividad.selectedItem.toString()
            val duracionStr = binding.etDuracion.text.toString().trim()
            val intensidadId = binding.rgIntensidad.checkedRadioButtonId



            val duracion = duracionStr.toInt()
            val calorias = Calculos.calcularCalorias(actividad, duracion, intensidadId)
            val resultado = "Has quemado aproximadamente %.2f calorías haciendo %s".format(calorias, actividad)
            binding.tvResultado.text = resultado
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}
