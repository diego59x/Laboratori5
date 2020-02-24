package com.example.laboratori4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.laboratori4.databinding.FragmentMainBinding
import com.example.laboratori4.databinding.FragmentPreguntasBinding


class Npregunta : Fragment(), View.OnClickListener {
    lateinit var binding2 : FragmentPreguntasBinding
    lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).supportActionBar?.title = "Npregunta"
    }

    override fun onClick(v: View?) {
        // Aqui se debe agregar la nueva pregunta, solo no se como a traves del binding llamar
        // o mas bien traer la lista de las preguntas que estan en el activity de preguntas
    }


}
