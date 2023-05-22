package com.jgarcia.parcial1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jgarcia.parcial1.R
import com.jgarcia.parcial1.databinding.FragmentPackageBinding
import com.jgarcia.parcial1.ui.pack.viewmodel.PackViewModel

class PackageFragment : Fragment() {


    //uso de binding para fragmento de paquete
    private lateinit var binding: FragmentPackageBinding

    //llamado al view model
    private val packViewModel: PackViewModel by activityViewModels{
        PackViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //aplicación de binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPackageBinding.inflate(inflater,container,false)
        return binding.root
    }


    //instanciar el viewmodel al binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = packViewModel

    }


}