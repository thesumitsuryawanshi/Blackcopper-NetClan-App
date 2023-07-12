package com.example.netclanapp.ui.Explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.R
import com.example.netclanapp.adapters.rv_PersonListAdapter
import com.example.netclanapp.databinding.FragmentExploreBinding
import com.example.netclanapp.databinding.FragmentPersonalBinding


class PersonalFragment : Fragment() {


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
                "Electronics",
                "Fasion",
                "Furniture",
                "Gifts",
                "Grosery",
                "Mobiles",
                "Grosery -2 ",
                "Grosery -3  "
            )

        val adapter = rv_PersonListAdapter(personList)

        binding.rvMusicList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvMusicList.adapter = adapter
        adapter.notifyItemInserted(personList.size - 1)
    }


}