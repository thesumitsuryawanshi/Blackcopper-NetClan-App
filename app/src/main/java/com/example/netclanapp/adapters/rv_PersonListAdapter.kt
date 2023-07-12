package com.example.netclanapp.adapters

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanapp.databinding.RvExploreItemsBinding

class rv_PersonListAdapter(val PersonList: List<String>) :
    RecyclerView.Adapter<rv_PersonListAdapter.ViewHolder>() {

    lateinit var binding: RvExploreItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvExploreItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.tvPName.text = PersonList[position]

    }

    override fun getItemCount(): Int {
        d("testing in RV ", "item count ; ${PersonList.size}")
        return PersonList.size
//        return 8
    }

    class ViewHolder(binding: RvExploreItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvPName = binding.tvPersonName
    }
}