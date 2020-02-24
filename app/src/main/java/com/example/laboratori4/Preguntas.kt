package com.example.laboratori4

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.example.laboratori4.databinding.FragmentPreguntasBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_preguntas.*


class Preguntas : Fragment(), View.OnClickListener{
    var preguntas: MutableList<String> = mutableListOf("¿Tiene algun comentario/sugerencia?","¿Que le parecio nuestro servicio?")
    var texto = view?.findViewById<TextView>(R.id.Preguntas)
    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var binding : FragmentPreguntasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_preguntas, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }



    override fun onClick(v: View?) {
      // Aqui debe dar siguiente a la siguiente pregunta para mostrar
        texto?.text = preguntas.get(0)
        val bundle = bundleOf("recipient" to encuesta.text.toString())
        navController!!.navigate(
            R.id.action_secondFragment_to_comentario, bundle
        )


    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater)
    }


}
