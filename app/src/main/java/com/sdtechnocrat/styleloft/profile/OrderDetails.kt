package com.sdtechnocrat.styleloft.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_order_details.*

/**
 * A simple [Fragment] subclass.
 */
class OrderDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList : ArrayList<String> = ArrayList()

        var adapter = ItemsOrderAdapter(dataList, requireContext())

        itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
        itemsRecycler.adapter = adapter

        var itemCount : String = adapter.itemCount.toString()
        txtItemCount.text = itemCount + " items"


    }
}
