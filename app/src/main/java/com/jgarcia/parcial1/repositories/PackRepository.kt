package com.jgarcia.parcial1.repositories

import com.jgarcia.parcial1.data.model.PackModel


//Repositorio que permite acceder a la lista mutalbe obtener los paquetes y añadir nuevos
class PackRepository(private val packs: MutableList<PackModel>) {
    fun getPack() = packs
    fun addPack(pack:PackModel) {
        packs.add(pack)
    }
}