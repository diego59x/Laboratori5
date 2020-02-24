package com.example.laboratori4


import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import android.view.MenuItem
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.example.laboratori4.databinding.FragmentMainBinding
import com.example.laboratori4.databinding.FragmentPreguntasBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

    lateinit var binding : FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.encuesta).setOnClickListener(this)

        (activity as MainActivity).supportActionBar?.title = "Guatemala"
    }


    override fun onClick(v: View?) {

            val bundle = bundleOf("recipient" to encuesta.text.toString())
            navController!!.navigate(
                R.id.action_mainFragment_to_secondFragment,
                bundle
            )


    }
    fun createQuestion(v: View?) {

        val bundle = bundleOf("recipient" to encuesta.text.toString())
        navController!!.navigate(
            R.id.action_mainFragment_to_biografia2,
            bundle
        )
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.biografia){
            navController!!.navigate(
                R.id.action_mainFragment_to_biografia2)
        }
        return super.onOptionsItemSelected(item)
    }
}
