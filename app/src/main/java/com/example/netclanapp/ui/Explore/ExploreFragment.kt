package com.example.netclanapp.ui.Explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.netclanapp.MainActivity
import com.example.netclanapp.databinding.FragmentExploreBinding
import com.example.netclanapp.ui.Explore.fragments.BusinessFrag
import com.example.netclanapp.ui.Explore.fragments.MerchantFrag
import com.example.netclanapp.ui.Explore.fragments.PersonalFrag
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPagerInit()
    }

    private fun viewPagerInit() {

        val tabLayout = binding.tlTabLayout
        val viewpager = binding.vpViewpager
        val tabNamesArray = arrayListOf("Personal", "Business", "Merchant")
        val fragmentArray = arrayListOf<Fragment>(PersonalFrag(), BusinessFrag(), MerchantFrag())
        val adapter = ExploreViewpagerAdapter(fragmentArray, activity as MainActivity)

        viewpager.adapter = adapter
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = tabNamesArray[position]
        }.attach()


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}