package com.sdtechnocrat.styleloft.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_checkout_page.*

/**
 * A simple [Fragment] subclass.
 */
class CheckoutPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout_page, container, false)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Checkout Page"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var dataList = ArrayList<String>()
        val adapter = DeliveryMethodsAdapter(dataList, requireContext())
        deliveryRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        deliveryRecycler.adapter = adapter

        paymentChangeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_checkoutPage_to_paymentMethods))
        addressChangeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_checkoutPage_to_selectAddress))
    }
}
