package com.sdtechnocrat.styleloft.checkout

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_add_address.*

/**
 * A simple [Fragment] subclass.
 */
class AddAddress : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText.setText("")
        addOneEditText.setText("")
        addTwoEditText.setText("")
        cityEditText.setText("")
        stateEditText.setText("")
        zipCodeEditText.setText("")
        countryEditText.setText("")

        val hasAddress: Boolean? = arguments?.getBoolean("hasAddress")
        if(hasAddress != null) {
            val fullName: String? = arguments?.getString("fullName", "")
            val addressOne: String? = arguments?.getString("addressOne", "")
            val addressTwo: String? = arguments?.getString("addressTwo", "")
            val city: String? = arguments?.getString("city", "")
            val state: String? = arguments?.getString("state", "")
            val zip: String? = arguments?.getString("zip", "")
            val country: String? = arguments?.getString("country", "")

            nameEditText.setText(fullName)
            addOneEditText.setText(addressOne)
            addTwoEditText.setText(addressTwo)
            cityEditText.setText(city)
            stateEditText.setText(state)
            zipCodeEditText.setText(zip)
            countryEditText.setText(country)

        }

        saveAddressBtn.setOnClickListener {
            var snackMessage: String
            if(hasAddress != null) {
                snackMessage = "Address Updated Successfully"
            } else {
                snackMessage = "Address Added Successfully"
            }
            Snackbar.make(it,snackMessage , Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(Color.parseColor("#FFFF00"))
                .setAction("Continue") {requireActivity().onBackPressed()}
                .show()
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Add Shipping Address"
    }
}
