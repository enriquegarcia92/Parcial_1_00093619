package com.jgarcia.parcial1.ui.pack.packages.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.jgarcia.parcial1.data.model.PackModel
import com.jgarcia.parcial1.databinding.PackItemBinding

class PackRecyclerViewHolder (private val binding: PackItemBinding): RecyclerView.ViewHolder(binding.root) {

    //intermediario entre la vista y el recycler view
    fun bind(pack: PackModel, clickListener: (PackModel) -> Unit) {
        binding.nameText.text = pack.nombre
        binding.priceText.text = pack.precio

        binding.firstCardView.setOnClickListener {
            clickListener(pack)
        }

    }
}