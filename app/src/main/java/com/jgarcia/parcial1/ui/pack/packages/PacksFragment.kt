package com.jgarcia.parcial1.ui.pack.packages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jgarcia.parcial1.R
import com.jgarcia.parcial1.data.model.PackModel
import com.jgarcia.parcial1.databinding.FragmentPacksBinding
import com.jgarcia.parcial1.ui.pack.packages.recyclerview.PackRecyclerViewAdapter
import com.jgarcia.parcial1.ui.pack.viewmodel.PackViewModel

class PacksFragment : Fragment() {

    private val packViewModel: PackViewModel by activityViewModels{
        PackViewModel.Factory
    }

    //instanciación de binding y recyclerview

    private lateinit var binding: FragmentPacksBinding
    private lateinit var adapter: PackRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPacksBinding.inflate(inflater,container,false)
        return binding.root
    }

    //seteo del recycler view y click listener para boton de navegación hacia pantalla de añadir paquete
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        binding.addbutton.setOnClickListener{
            packViewModel.clearData()
            it.findNavController().navigate(R.id.action_packsFragment_to_addPackFragment)
        }
    }

    //Mostrar paquete seleccionado en otra ventana y llamado a función de viewmodel que extrae solo uno de la lista
    private fun showSelectedPack(pack:PackModel){
        packViewModel.selectedPackage(pack)
        findNavController().navigate(R.id.action_packsFragment_to_packageFragment)
    }


    //Función que obtiene y coloca los paquetes en los items del recyclerview
    private fun displayPacks(){
        adapter.setData(packViewModel.getPacks())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view:View){
        //toda la configuración del click y de la muestra de itesm del recycler view
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PackRecyclerViewAdapter { selectedPack->
            showSelectedPack(selectedPack)
        }
        binding.recyclerView.adapter=adapter
        displayPacks()
    }
}