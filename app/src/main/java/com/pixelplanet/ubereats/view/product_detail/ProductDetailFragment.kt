package com.pixelplanet.ubereats.view.product_detail

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixelplanet.ubereats.base.BaseFragment
import com.pixelplanet.ubereats.databinding.FragmentProductDetailBinding

class ProductDetailFragment : BaseFragment() {

    private lateinit var productDetailBinding: FragmentProductDetailBinding

    private var dummyData = listOf("","")
    private val productVariantAdapter by lazy {
        ProductVariantAdapter(requireContext())
    }
    private val toppingsAdapter by lazy {
        ToppingsAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        productDetailBinding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return productDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set strike through text
        productDetailBinding.tvRealPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

        productDetailBinding.rvProductVariant.adapter= productVariantAdapter
        productVariantAdapter.insertData(dummyData)

        productDetailBinding.rvToppings.adapter= toppingsAdapter
        toppingsAdapter.insertData(dummyData)

    }
}