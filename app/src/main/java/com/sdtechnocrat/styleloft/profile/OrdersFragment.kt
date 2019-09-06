package com.sdtechnocrat.styleloft.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_orders.*

/**
 * A simple [Fragment] subclass.
 */
class OrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "My orders"

        txtDelivered.isSelected = true

        txtDelivered.setOnClickListener{
            txtDelivered.isSelected = true
            txtProcessing.isSelected = false
            txtCancelled.isSelected = false
        }

        txtProcessing.setOnClickListener{
            txtDelivered.isSelected = false
            txtProcessing.isSelected = true
            txtCancelled.isSelected = false
        }

        txtCancelled.setOnClickListener{
            txtDelivered.isSelected = false
            txtProcessing.isSelected = false
            txtCancelled.isSelected = true
        }

        val dataList : ArrayList<String> = ArrayList()

        orderRecycler.layoutManager = LinearLayoutManager(requireContext())
        orderRecycler.adapter = OrdersAdapter(dataList, requireContext())


    }


}
