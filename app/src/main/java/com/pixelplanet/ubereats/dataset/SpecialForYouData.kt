package com.pixelplanet.ubereats.dataset

import com.pixelplanet.ubereats.R

class SpecialForYouData(
    val img: Int = 0,
    val price: String = "",
    val title: String = "",
    val star: String = "",
    val distance: String = ""
) {
    fun getData() : List<SpecialForYouData> {
        val data : MutableList<SpecialForYouData> = ArrayList()

        data.add(SpecialForYouData(
            R.drawable.img_promo_donuts,
            "15.000",
            "Holic Power\nSpicy Noodle",
            "5.0",
            "0.8"
        ))
        data.add(SpecialForYouData(
            R.drawable.img_special_donuts,
            "75.000",
            "Creamy\nDonuts",
            "4.5",
            "1.1"
        ))
        data.add(SpecialForYouData(
            R.drawable.img_promo_donuts,
            "12.000",
            "Swiwings Hot\nGarlics",
            "4.0",
            "1.7"
        ))

        return data
    }

}