package com.deepsaikia.nitsgms.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.deepsaikia.nitsgms.ChatBot
import com.deepsaikia.nitsgms.CreateComplaint
import com.deepsaikia.nitsgms.R
import com.deepsaikia.nitsgms.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        val chatBotActivate: ExtendedFloatingActionButton = binding.sellButton
        chatBotActivate.setOnClickListener {
            val intent = Intent(requireContext(),ChatBot::class.java)
            startActivity(intent)
        }
        binding.register.setOnClickListener {
            val intent = Intent(requireContext(), CreateComplaint::class.java)
            startActivity(intent)
        }

        binding.list.setOnClickListener {
            fragmentload(FragmentComplainList())
            //Toast.makeText(applicationContext,"clicked", Toast.LENGTH_SHORT).show()
        }

        return binding.root

    }
    private fun fragmentload(fragment : Fragment)
    {

        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrameLayout, fragment)
        fragmentTransaction.commit()

    }


}