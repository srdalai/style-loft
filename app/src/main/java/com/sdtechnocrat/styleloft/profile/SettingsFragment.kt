package com.sdtechnocrat.styleloft.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.sdtechnocrat.styleloft.R

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "Settings"


    }


}
