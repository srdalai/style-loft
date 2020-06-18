package com.sdtechnocrat.styleloft.ui


import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.sdtechnocrat.styleloft.CheckoutActivity

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.component_promocode_layout.*
import kotlinx.android.synthetic.main.fragment_bag.*
import kotlinx.android.synthetic.main.fragment_bag.applyFrame
import kotlinx.android.synthetic.main.fragment_bag.promoEditText
import kotlinx.android.synthetic.main.fragment_bag.removeFrame

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

        promoEditText.setOnClickListener{showBottomSheet()}

        val dataList : ArrayList<String> = ArrayList()

        itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
        itemsRecycler.adapter = BagItemsAdapter(dataList, requireContext())


    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.component_promocode_layout, null)
        val dataList : ArrayList<String> = ArrayList()
        val promoRecycler: RecyclerView = dialogView.findViewById<RecyclerView>(R.id.promoCodesRecycler)
        promoRecycler.layoutManager = LinearLayoutManager(requireContext())
        promoRecycler.adapter = PromoCodesAdapter(dataList, requireContext())
        val dialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
        dialog.setContentView(dialogView)
        dialog.show()
    }
}
