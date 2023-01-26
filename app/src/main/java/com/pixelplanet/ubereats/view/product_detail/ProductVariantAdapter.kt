package com.pixelplanet.ubereats.view.product_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pixelplanet.ubereats.databinding.ItemProductVariantListBinding
import java.util.ArrayList

class ProductVariantAdapter(
    val context: Context
) : RecyclerView.Adapter<ProductVariantAdapter.ViewHolder>() {

    var items : MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductVariantListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items.getOrNull(position)!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: ItemProductVariantListBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(data: String){
            with(binding){

            }
        }
    }

    fun insertData(data : List<String>){
        data.forEach {
            items.add(it)
            notifyItemInserted(items.size - 1)
        }
    }
    fun clearData() {
        if (items.isNotEmpty()) {
            items.clear()
            notifyDataSetChanged()
        }
    }
}