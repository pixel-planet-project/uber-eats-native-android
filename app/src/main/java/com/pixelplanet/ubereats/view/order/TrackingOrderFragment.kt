package com.pixelplanet.ubereats.view.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pixelplanet.ubereats.R
import com.pixelplanet.ubereats.base.BaseFragment
import com.pixelplanet.ubereats.databinding.FragmentTrackingOrderBinding

class TrackingOrderFragment : BaseFragment() {

    private lateinit var trackingOrderBinding: FragmentTrackingOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        trackingOrderBinding = FragmentTrackingOrderBinding.inflate(inflater, container, false)
        return trackingOrderBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackingOrderBinding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}