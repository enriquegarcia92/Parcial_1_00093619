package com.jgarcia.parcial1.ui.pack.addpackage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jgarcia.parcial1.R
import com.jgarcia.parcial1.databinding.FragmentAddPackBinding
import com.jgarcia.parcial1.ui.pack.viewmodel.PackViewModel

class AddPackFragment : Fragment() {

    private lateinit var binding: FragmentAddPackBinding

    private val packViewModel: PackViewModel by viewModels(){
        PackViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPackBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    //instanciaón del viewmodel

    private fun setViewModel(){
        binding.viewmodel = packViewModel
    }


    //Creación de observer que permite modificar en tiempo real la información que se va modificando
    private fun observeStatus(){
        packViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(PackViewModel.WRONG_INFORMATION)->{
                    Log.d(APP_TAG,status)
                    packViewModel.clearStatus()
                }
                status.equals(PackViewModel.PACK_CREATED)->{
                    Log.d(APP_TAG,status)
                    Log.d(APP_TAG,packViewModel.getPacks().toString())
                    packViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG="APP_TAG"
    }

}