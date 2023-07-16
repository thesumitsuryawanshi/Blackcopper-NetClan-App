package com.example.netclanapp.ui.Explore


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExploreViewpagerAdapter(val items: ArrayList<Fragment>, activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return items.size
    }
    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}