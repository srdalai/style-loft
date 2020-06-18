package com.sdtechnocrat.styleloft.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_favorites.*

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    var isList : Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "Favorites"

        changeLayout.setOnClickListener {

        }

        val dataList : ArrayList<String> = ArrayList()

        itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
        itemsRecycler.adapter = FavoritesAdapter(dataList, requireContext())
    }

    fun changeListLayout() {
        if (isList) {

        }
    }
}
