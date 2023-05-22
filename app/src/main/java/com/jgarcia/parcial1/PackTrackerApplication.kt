package com.jgarcia.parcial1

import android.app.Application
import com.jgarcia.parcial1.data.packs
import com.jgarcia.parcial1.repositories.PackRepository

class PackTrackerApplication:Application() {
    val packRepository: PackRepository by lazy {
        PackRepository(packs)
    }
}