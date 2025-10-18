package com.example.practica1moviles20100816.utils

import com.example.practica1moviles20100816.R


object Calculos {

    fun calcularAgua(peso: Float, generoFactor: Double): Double {
        return peso * 0.035 * generoFactor
    }

    fun calcularCalorias(actividad: String, duracion: Int, intensidadId: Int): Double {
        val caloriasPorMinuto = when (actividad) {
            "Correr" -> 10
            "Caminar" -> 5
            "Nadar" -> 8
            "Ciclismo" -> 7
            "Yoga" -> 4
            else -> 0
        }

        val factorIntensidad = when (intensidadId) {
            R.id.rbBaja -> 0.8
            R.id.rbMedia -> 1.0
            R.id.rbAlta -> 1.2
            else -> 1.0
        }

        return caloriasPorMinuto * duracion * factorIntensidad
    }
}
