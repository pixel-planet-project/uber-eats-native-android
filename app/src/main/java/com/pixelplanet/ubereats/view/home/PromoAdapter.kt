package com.pixelplanet.ubereats.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.pixelplanet.ubereats.databinding.ItemListPromoBinding
import com.pixelplanet.ubereats.dataset.PromoData
import java.util.ArrayList

class PromoAdapter(
    val context: Context
) : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {

    var items : MutableList<PromoData> = ArrayList()

    interface Listener{
        fun onClick(it: PromoData)
    }

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListPromoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items.getOrNull(position)!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: ItemListPromoBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(data: PromoData){
            with(binding){
                iv.setImageDrawable(ActivityCompat.getDrawable(context, data.img))
                tvDiscount.text = "${data.discount}% off"
                tvTitle.text = data.title
                tvRating.text = data.star
                tvDistance.text = "${data.distance} km"

                layParent.setOnClickListener {
                    listener?.onClick(data)
                }
            }
        }
    }

    fun insertData(data : List<PromoData>){
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