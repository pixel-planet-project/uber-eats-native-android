package com.pixelplanet.ubereats.dataset

import com.pixelplanet.ubereats.R

class PromoData(
    val img: Int = 0,
    val discount: String = "",
    val title: String = "",
    val star: String = "",
    val distance: String = ""
) {
    fun getData() : List<PromoData> {
        val data : MutableList<PromoData> = ArrayList()

        data.add(PromoData(
            R.drawable.img_promo_donuts,
            "35",
            "Hawkins\nDonuts",
            "5.0",
            "0.8"
        ))
        data.add(PromoData(
            R.drawable.img_promo_pizza,
            "25",
            "Pineapple\nPizza",
            "4.5",
            "1.1"
        ))
        data.add(PromoData(
            R.drawable.img_promo_donuts,
            "15",
            "Noodles\nHolic",
            "4.0",
            "1.7"
        ))

        return data
    }

}