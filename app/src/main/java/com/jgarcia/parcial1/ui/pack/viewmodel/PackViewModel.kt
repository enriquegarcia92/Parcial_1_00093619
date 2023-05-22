package com.jgarcia.parcial1.ui.pack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jgarcia.parcial1.PackTrackerApplication
import com.jgarcia.parcial1.data.model.PackModel
import com.jgarcia.parcial1.repositories.PackRepository

class PackViewModel (private val repository: PackRepository): ViewModel() {

    //variables mutables para uso de live data
    var name = MutableLiveData("")
    var precio = MutableLiveData("")
    var status = MutableLiveData("")

    //obtener paquetes
    fun getPacks() = repository.getPack()

    //crear paquetes
    private fun addPack(pack:PackModel){
        repository.addPack(pack)
    }

    //preparar y generar un paquete para insersión
    public fun createPack(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val pack = PackModel(
            name.value!!,
            precio.value!!,
        )
        println(pack)
        addPack(pack)
        clearData()
        status.value = PACK_CREATED
    }

    //limpiar información

    fun clearData() {
        name.value=""
        precio.value=""
    }

    //limpiar el estado

    fun clearStatus(){
        status.value= INACTIVE
    }

    //seleccionar el paquete clickado en el recylcer view para guardarlo en las variables mutables

    fun selectedPackage(pack:PackModel){
        name.value = pack.nombre
        precio.value = pack.precio
    }


    //validar que la información no esté vacia
    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty()->return false;
            precio.value.isNullOrEmpty()->return false;
        }
        return true;
    }

    //Instancia de la factory y varialbes de texto auxiliares para revisión en consola

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PackTrackerApplication
                PackViewModel(app.packRepository)
            }
        }
        const val PACK_CREATED = "Package created"
        const val WRONG_INFORMATION= "Wrong information"
        const val INACTIVE=""

    }
}