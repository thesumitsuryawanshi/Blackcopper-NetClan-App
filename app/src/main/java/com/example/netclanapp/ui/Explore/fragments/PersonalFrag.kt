package com.example.netclanapp.ui.Explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.MainActivity
import com.example.netclanapp.R
import com.example.netclanapp.databinding.ActivityMainBinding
import com.example.netclanapp.databinding.FragmentPersonalBinding

class PersonalFrag : Fragment() {

    lateinit var binding: FragmentPersonalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentPersonalBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvSetUp()
        return root
    }

    fun rvSetUp() {

        val personList =
            listOf(
                " Snehal Mane",
                " Gayatri Kolapkar",
                " Gayatri Yendhe",
                " Torna Patil",
                " Shweta Swami",
                " Snehal Waghmare",
                " Dipali Gole ",
                " Vikrant Mandake "
            )

        val adapter = rv_PersonListAdapter(personList)

        binding.rvPersonsList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvPersonsList.adapter = adapter
        adapter.notifyItemInserted(personList.size - 1)



        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.Global_Action_to_filterFragment)
        }
    }

}