package com.jgarcia.parcial1.ui.pack.packages.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgarcia.parcial1.data.model.PackModel
import com.jgarcia.parcial1.data.packs
import com.jgarcia.parcial1.databinding.PackItemBinding


//toda la configuración para el recyclerview
class PackRecyclerViewAdapter(
    private val clickListener:(PackModel)->Unit
): RecyclerView.Adapter<PackRecyclerViewHolder> (){
    private val packs = ArrayList<PackModel>()

    fun setData(packList: List<PackModel>){
        packs.clear()
        packs.addAll(packList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackRecyclerViewHolder {
        val binding = PackItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PackRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return packs.size
    }

    override fun onBindViewHolder(holder: PackRecyclerViewHolder, position: Int) {
        val pack = packs[position]
        holder.bind(pack,clickListener)
    }
}

