package com.example.edwfrefref

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.edwfrefref.databinding.RowItemBinding
import com.example.edwfrefref.network.MarsProperty




class recycler_grid_adapter(private val onClickListener: OnClickListener):ListAdapter<MarsProperty,
        recycler_grid_adapter.RecyclerGridViewHolder>(DiffCallback){


   companion object DiffCallback:DiffUtil.ItemCallback<MarsProperty>() {
       override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
           return oldItem === newItem
       }

       override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
       return oldItem.id==newItem.id
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerGridViewHolder {
        return RecyclerGridViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerGridViewHolder, position: Int) {
        val property=getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(property)
        }
        holder.bind(property)
    }


    class OnClickListener(val clickListener:(marsProperty:MarsProperty)-> Unit){
        fun onClick(marsProperty: MarsProperty)=clickListener(marsProperty)
    }


    class RecyclerGridViewHolder(val binding: RowItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty) {
            binding.property = marsProperty
 //        binding.executePendingBindings()
        }
    }



}




































//class recycler_grid_adapter : ListAdapter<MarsProperty,
//        recycler_grid_adapter.MarsPropertyViewHolder>(DiffCallback) {
//
//companion object DiffCallback:DiffUtil.ItemCallback<MarsProperty>(){
//    override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//       return oldItem === newItem
//    }
//
//    override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//}
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): MarsPropertyViewHolder {
//    return MarsPropertyViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context)))
//    }
//
//
//    override fun onBindViewHolder(
//        holder: MarsPropertyViewHolder,
//        position: Int
//    ) {
//        val property=getItem(position)
//        holder.bind(property)
//    }
//
//
//    class MarsPropertyViewHolder(var binding: RowItemBinding)
//        : RecyclerView.ViewHolder(binding.root) {
//            fun bind(marsProperty: MarsProperty){
//                binding.property=marsProperty
//                binding.executePendingBindings()
//            }
//
//    }
//
//}