package com.sdtechnocrat.styleloft.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_payment_methods.*

/**
 * A simple [Fragment] subclass.
 */
class PaymentMethods : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_methods, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataList = ArrayList<String>()
        paymentRecycler.layoutManager = LinearLayoutManager(requireContext())
        paymentRecycler.adapter = PaymentMethodsAdapter(dataList, requireContext())
    }

}
