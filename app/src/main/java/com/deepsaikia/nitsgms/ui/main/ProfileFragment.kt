package com.deepsaikia.nitsgms.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deepsaikia.nitsgms.CreateComplaint
import com.deepsaikia.nitsgms.MainActivity
import com.deepsaikia.nitsgms.R
import com.deepsaikia.nitsgms.data.UserData
import com.deepsaikia.nitsgms.databinding.FragmentComplainListBinding
import com.deepsaikia.nitsgms.databinding.FragmentProfileBinding
import com.deepsaikia.nitsgms.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val myReference: DatabaseReference =database.reference.child("Users")

    private var viewBinding: FragmentProfileBinding?=null
    private val binding get()= viewBinding!!
    private var valueEventListener: ValueEventListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(inflater, container, false)
        retriveDataFromDatabase()
        binding.buttonLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        return binding.root
    }

    private fun retriveDataFromDatabase() {
        valueEventListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val user = snapshot.child(Firebase.auth.currentUser?.uid.toString()).getValue(
                    UserData::class.java)
                if (user != null){
                    binding.EMAIL.text=user.email
                    println("Hello ${user.name}")
                    binding.USERNAME.text=user.name
                    binding.dept.text=user.scholarId
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }

        }
        myReference.addValueEventListener(valueEventListener!!)
    }

}