package com.example.galeritutorial.ui.first.adapter

import com.example.galeritutorial.R
import com.example.galeritutorial.binding.DataBoundAdapter
import com.example.galeritutorial.binding.DataBoundViewHolder
import com.example.galeritutorial.databinding.FirstItemImageBinding
import com.example.galeritutorial.interfaces.ISpaceX
import com.example.galeritutorial.model.LaunchesEntityItem

class AdapterSpaceX(private val launches:List<LaunchesEntityItem>,private val iSpaceX:ISpaceX):DataBoundAdapter<FirstItemImageBinding>(R.layout.first_item_image){
    override fun bindItem(
        holder: DataBoundViewHolder<FirstItemImageBinding>,
        position: Int,
        payloads: List<Any>
    ) {
        holder.binding.data = launches[position]
        holder.binding.callback = iSpaceX

    }

    override fun getItemCount(): Int {
        return launches.size
    }


}