package com.sdtechnocrat.styleloft.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sdtechnocrat.styleloft.R

/**
 * A simple [Fragment] subclass.
 */
class SelectAddress : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_address, container, false)
    }

}
