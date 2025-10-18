package com.example.practica1moviles20100816.auto



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica1moviles20100816.databinding.ActivityCatalogoAutosBinding
import com.example.practica1moviles20100816.model.Auto

class CatalogoAutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatalogoAutosBinding

    // Lista mock de autos deportivos
    private val autos = listOf(
        Auto(
            "Ferrari",
            "488 GTB",
            250000.0,
            "https://cdn.motor1.com/images/mgl/7xVq3/s3/ferrari-488-gtb.jpg"
        ),
        Auto("Lamborghini", "Huracán EVO", 261000.0, "https://cdn.motor1.com/images/mgl/NKvJN/s3/lamborghini-huracan-evo.jpg"),
        Auto("Porsche", "911 Carrera", 115000.0, "https://cdn.motor1.com/images/mgl/XJ6GJ/s3/2020-porsche-911-carrera.jpg"),
        Auto("McLaren", "720S", 299000.0, "https://cdn.motor1.com/images/mgl/7xVq3/s3/ferrari-488-gtb.jpg"),
        Auto("Audi", "R8", 142000.0, "https://cdn.motor1.com/images/mgl/6XM2V/s3/audi-r8-v10-plus.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogoAutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView con LayoutManager vertical
        binding.recyclerViewAutos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAutos.adapter = AutoAdapter(autos)

        // Calcular costo total
        val totalCosto = autos.sumOf { it.precio }
        binding.tvTotalCosto.text = "Costo total: \$${"%,.2f".format(totalCosto)}"

        // Botón para regresar al menú principal
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}
