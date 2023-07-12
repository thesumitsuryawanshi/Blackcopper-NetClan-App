package com.example.netclanapp.ui.Explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.databinding.FragmentMerchantBinding


class MerchantFrag : Fragment() {

    lateinit var binding: FragmentMerchantBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentMerchantBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvSetUp()
        return root
    }

    private fun rvSetUp() {
        val MerchantList =
            listOf(
                " Saileela Ambulance Services Pimpari Chinchwad",
                " Sanvi Medical Chemist & Drugist",
                " Shrinivasa Pg",
                " Sanmarth Medical nd genaral Store",
                " Om Sai Ambulance Services 24 Hrs Open",
                " Shree Datata Cardiac Ambulance Services ",
                " Hotel 21-BlueWater",
                " BTW Visa Services India pvt. Ltd "
            )

        val adapter = rv_MerchantListAdapter(MerchantList)

        binding.rvMerchantsList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvMerchantsList.adapter = adapter
        adapter.notifyItemInserted(MerchantList.size - 1)
    }


}