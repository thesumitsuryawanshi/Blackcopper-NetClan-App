package com.example.netclanapp.ui.Explore.fragments

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanapp.databinding.RvExplorePersonalItemsBinding

class rv_PersonListAdapter(val rv_PersonListAdapter: List<String>) :
    RecyclerView.Adapter<rv_PersonListAdapter.ViewHolder>() {

    lateinit var binding: RvExplorePersonalItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvExplorePersonalItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        val viewholder = ViewHolder(view)
        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvPName.text = rv_PersonListAdapter[position]
    }

    override fun getItemCount(): Int {
        d("testing in RV ", "item count ; ${rv_PersonListAdapter.size}")
        return rv_PersonListAdapter.size
//        return 8
    }

    class ViewHolder(binding: RvExplorePersonalItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvPName = binding.tvPersonName
    }
}