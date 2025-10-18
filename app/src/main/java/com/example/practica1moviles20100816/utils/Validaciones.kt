package com.example.practica1moviles20100816.utils



import android.content.Context
import android.widget.Toast


object Validaciones {
    fun validarCamposAgua(nombre: String, pesoStr: String, generoFactor: Double?, context: Context): Boolean {
        if (nombre.isEmpty() || pesoStr.isEmpty() || generoFactor == null) {
            Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false
        }

        val peso = pesoStr.toFloatOrNull()
        if (peso == null || peso < 5 || peso > 200) {
            Toast.makeText(context, "El peso debe estar entre 5 y 200 kg", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun validarCamposActividad(duracionStr: String, intensidadId: Int, context: Context): Boolean {
        if (duracionStr.isEmpty() || intensidadId == -1) {
            Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false
        }

        val duracion = duracionStr.toIntOrNull()
        if (duracion == null || duracion <= 0) {
            Toast.makeText(context, "La duración debe ser un número positivo", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
