package com.pixelplanet.ubereats.view.home

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pixelplanet.ubereats.R
import com.pixelplanet.ubereats.base.BaseFragment
import com.pixelplanet.ubereats.databinding.FragmentHomeBinding
import com.pixelplanet.ubereats.dataset.PromoData
import com.pixelplanet.ubereats.dataset.SpecialForYouData

class HomeFragment : BaseFragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    private val promoAdapter by lazy(LazyThreadSafetyMode.NONE){
        PromoAdapter(requireContext())
    }
    private val specialForYouAdapter by lazy(LazyThreadSafetyMode.NONE){
        SpecialForYouAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.rvPromo.adapter = promoAdapter
        promoAdapter.insertData(PromoData().getData())
        promoAdapter.listener = object: PromoAdapter.Listener{
            override fun onClick(it: PromoData) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToProductDetailFragment()
                )
            }

        }

        homeBinding.rvSpecial.adapter = specialForYouAdapter
        specialForYouAdapter.insertData(SpecialForYouData().getData())

        //set strike through text
        homeBinding.tvRealPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

        homeBinding.layOrderProgress.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTrackingOrderFragment()
            )
        }
    }
}