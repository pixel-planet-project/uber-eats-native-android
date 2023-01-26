package com.pixelplanet.ubereats.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.pixelplanet.ubereats.databinding.ItemListSpecialBinding
import com.pixelplanet.ubereats.dataset.SpecialForYouData
import java.util.ArrayList

class SpecialForYouAdapter(
    val context: Context
) : RecyclerView.Adapter<SpecialForYouAdapter.ViewHolder>() {

    var items : MutableList<SpecialForYouData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListSpecialBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items.getOrNull(position)!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: ItemListSpecialBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(data: SpecialForYouData){
            with(binding){
                iv.setImageDrawable(ActivityCompat.getDrawable(context, data.img))
                tvTitle.text = data.title
                tvRating.text = data.star
                tvDistance.text = "${data.distance} km"
                tvPrice.text = "Rp ${data.price}"
            }
        }
    }

    fun insertData(data : List<SpecialForYouData>){
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