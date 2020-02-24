package com.example.laboratori4

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.laboratori4.databinding.FragmentComentarioBinding

/**
 * A simple [Fragment] subclass.
 */
class Resultados : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var binding : FragmentComentarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_resultados, container, false)
        // Inflate the layout for this fragment
        return binding.root
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.textView).text = recipient
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as MainActivity).supportActionBar?.title = "Resultados"
    }

    override fun onClick(v: View?) {
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.share){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val sharedbody = "Comment"
            val sharedsub: String = binding.textView.text.toString()
            intent.putExtra(Intent.EXTRA_SUBJECT, sharedbody)
            intent.putExtra(Intent.EXTRA_TEXT, sharedsub)
            startActivity(Intent.createChooser(intent, "Share Using"))
        }
        return super.onOptionsItemSelected(item)
    }

}
