package com.example.practica1moviles20100816.auto

import com.example.practica1moviles20100816.model.Auto



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica1moviles20100816.databinding.ItemAutoBinding


class AutoAdapter(private val autos: List<Auto>) :
    RecyclerView.Adapter<AutoAdapter.AutoViewHolder>() {

    class AutoViewHolder(val binding: ItemAutoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoViewHolder {
        val binding = ItemAutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) {
        val auto = autos[position]
        holder.binding.tvMarcaModelo.text = "${auto.marca} - ${auto.modelo}"
        holder.binding.tvPrecio.text = "Precio: $${String.format("%,.2f", auto.precio)}"
        Glide.with(holder.itemView.context).load(auto.imagenUrl).into(holder.binding.ivAuto)
    }

    override fun getItemCount(): Int = autos.size
}
