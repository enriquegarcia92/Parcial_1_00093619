package com.jgarcia.parcial1.repositories

import com.jgarcia.parcial1.data.model.PackModel

class PackRepository(private val packs: MutableList<PackModel>) {
    fun getPack() = packs
    fun addPack(pack:PackModel) {
        packs.add(pack)
    }
}