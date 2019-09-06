package com.sdtechnocrat.styleloft.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "My profile"

        settingsRel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navigation_profile_to_settingsFragment))
        myOrdersRel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navigation_profile_to_ordersFragment))


    }
}
