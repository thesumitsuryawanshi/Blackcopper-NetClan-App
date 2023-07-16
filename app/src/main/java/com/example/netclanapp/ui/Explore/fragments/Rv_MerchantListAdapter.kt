package com.example.netclanapp.ui.Explore.fragments

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanapp.databinding.RvExploreMerchantItemsBinding

class rv_MerchantListAdapter(val MerchantList: List<String>) :
    RecyclerView.Adapter<rv_MerchantListAdapter.ViewHolder>() {

    lateinit var binding: RvExploreMerchantItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RvExploreMerchantItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.tvPName.text = MerchantList[position]

    }

    override fun getItemCount(): Int {
        d("testing in RV ", "item count ; ${MerchantList.size}")
        return MerchantList.size
//        return 8
    }

    class ViewHolder(binding: RvExploreMerchantItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvPName = binding.tvPersonName
    }
}
