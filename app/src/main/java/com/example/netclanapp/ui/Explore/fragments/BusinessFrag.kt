package com.example.netclanapp.ui.Explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.databinding.FragmentBusinessBinding


class BusinessFrag : Fragment() {

    lateinit var binding: FragmentBusinessBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentBusinessBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvSetUp()
        return root
    }

    private fun rvSetUp() {

        val BusinessList =
            listOf(
                " Shweta Swami",
                " Gayatri Kolapkar",
                " Snehal Waghmare",
                " Gayatri Yendhe",
                " Snehal Mane",
                " Torna Patil",
                " Vikrant Mandake ",
                " Dipali Gole  "
            )

        val adapter = rv_BusinessListAdapter(BusinessList)

        binding.rvBusinesssList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvBusinesssList.adapter = adapter
        adapter.notifyItemInserted(BusinessList.size - 1)

    }
}