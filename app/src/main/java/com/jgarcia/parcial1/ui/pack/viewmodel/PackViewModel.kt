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
    var name = MutableLiveData("")
    var precio = MutableLiveData("")
    var status = MutableLiveData("")

    fun getPacks() = repository.getPack()

    private fun addPack(pack:PackModel){
        repository.addPack(pack)
    }

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
        status.value = CAR_CREATED
    }


    fun clearData() {
        name.value=""
        precio.value=""
    }

    fun clearStatus(){
        status.value= INACTIVE
    }

    fun selectedPackage(pack:PackModel){
        name.value = pack.nombre
        precio.value = pack.precio
    }

    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty()->return false;
            precio.value.isNullOrEmpty()->return false;
        }
        return true;
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PackTrackerApplication
                PackViewModel(app.packRepository)
            }
        }
        const val CAR_CREATED = "Package created"
        const val WRONG_INFORMATION= "Wrong information"
        const val INACTIVE=""

    }
}