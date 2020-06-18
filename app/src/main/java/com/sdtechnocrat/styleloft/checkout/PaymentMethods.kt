package com.sdtechnocrat.styleloft.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_payment_methods.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sdtechnocrat.styleloft.R
import com.sdtechnocrat.styleloft.model.PaymentMethodData


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

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Payment Methods"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paymentRecycler.layoutManager = LinearLayoutManager(requireContext())
        paymentRecycler.adapter = PaymentMethodsAdapter(preparePaymentData(), requireContext())

        fabAdd.setOnClickListener { showBottomSheet() }
    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.component_add_new_card_layout, null)
        val dialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
        dialog.setContentView(dialogView)
        dialog.show()
    }

    private fun preparePaymentData(): ArrayList<PaymentMethodData> {
        val dataList = ArrayList<PaymentMethodData>()
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", true))
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", false))
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", false))
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", false))
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", false))
        dataList.add(PaymentMethodData("0000111122223333", "11/22", "001", "John Doe", "Credit Card", "VISA", "SBI", false))
        return dataList

    }

}
