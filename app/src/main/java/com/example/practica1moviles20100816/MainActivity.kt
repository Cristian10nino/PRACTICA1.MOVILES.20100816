package com.example.practica1moviles20100816

import com.example.practica1moviles20100816.agua.CalculadoraAguaActivity
import com.example.practica1moviles20100816.auto.CatalogoAutosActivity
import com.example.practica1moviles20100816.registro.RegistroActividadActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1moviles20100816.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgua.setOnClickListener {
            startActivity(Intent(this, CalculadoraAguaActivity::class.java))
        }

        binding.btnActividad.setOnClickListener {
            startActivity(Intent(this, RegistroActividadActivity::class.java))
        }

        binding.btnAutos.setOnClickListener {
            startActivity(Intent(this, CatalogoAutosActivity::class.java))
        }
    }
}

