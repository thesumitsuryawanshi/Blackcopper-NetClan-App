package com.example.netclanapp.ui.Explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.R
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
                " Sai Ambulance Services",
                " Sanvi Medical Store ",
                " Shrinivasa Pg",
                " Sanmarth Medical Store",
                " Om Ambulance Services 24 Hrs",
                " Shree Cardiac Ambulance Services ",
                " Hotel 21-BlueWater",
                " BTW Visa Services "
            )

        val adapter = rv_MerchantListAdapter(MerchantList)

        binding.rvMerchantsList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvMerchantsList.adapter = adapter
        adapter.notifyItemInserted(MerchantList.size - 1)



        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.Global_Action_to_filterFragment)
        }
    }


}