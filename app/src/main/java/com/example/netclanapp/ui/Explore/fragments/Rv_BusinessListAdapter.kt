package com.example.netclanapp.ui.Explore.fragments

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanapp.databinding.RvExploreBusinessItemsBinding

class rv_BusinessListAdapter(val BusinessList: List<String>) :
    RecyclerView.Adapter<rv_BusinessListAdapter.ViewHolder>() {

    lateinit var binding: RvExploreBusinessItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvExploreBusinessItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.tvPName.text = BusinessList[position]

    }

    override fun getItemCount(): Int {
        d("testing in RV ", "item count ; ${BusinessList.size}")
        return BusinessList.size
//        return 8
    }

    class ViewHolder(binding: RvExploreBusinessItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvPName = binding.tvPersonName

    }
}