package com.jgarcia.parcial1

import android.app.Application
import com.jgarcia.parcial1.data.packs
import com.jgarcia.parcial1.repositories.PackRepository


//Instanciar el repositorio en un entorno que nunca muere dentor de la aplicación, adempas se cambia nombre de la app en el manifest
class PackTrackerApplication:Application() {
    val packRepository: PackRepository by lazy {
        PackRepository(packs)
    }
}