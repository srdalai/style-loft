package com.sdtechnocrat.styleloft.ui


import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.snackbar.Snackbar
import com.sdtechnocrat.styleloft.CheckoutActivity

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_bag.*

/**
 * A simple [Fragment] subclass.
 */
class BagFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "My Bag"


        applyFrame.setOnClickListener {
            var promocode : String = promoEditText.text.toString()
            if (promocode.isNotEmpty()) {
                Snackbar.make(it, "Promocode applied successfully!", Snackbar.LENGTH_SHORT).show()
                promoEditText.isEnabled = false
                applyFrame.visibility = View.GONE
                removeFrame.visibility = View.VISIBLE
            } else {
                Snackbar.make(it, "Please apply a valid Promocode!", Snackbar.LENGTH_SHORT).show()
            }
        }

        removeFrame.setOnClickListener {
            Snackbar.make(it, "Promocode removed successfully!", Snackbar.LENGTH_SHORT).show()
            promoEditText.isEnabled = true
            promoEditText.setText("")
            applyFrame.visibility = View.VISIBLE
            removeFrame.visibility = View.GONE
        }

        checkoutBtn.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), CheckoutActivity::class.java))
        }

        val dataList : ArrayList<String> = ArrayList()

        itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
        itemsRecycler.adapter = BagItemsAdapter(dataList, requireContext())


    }
}
