package com.sdtechnocrat.styleloft.profile


import android.app.DatePickerDialog
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

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

        personalInfoRel.setOnClickListener { toggleInfoView() }

        passwordRel.setOnClickListener { togglePasswordView() }

        txtUpdate.setOnClickListener { updateInfo() }

        txtChange.setOnClickListener { showBottomSheet() }

        editTextDOB.setOnClickListener { setDate() }


    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.component_change_password_layout, null)
        val dialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
        dialog.setContentView(dialogView)
        dialog.show()
    }

    private fun togglePasswordView() {
        if (txtChange.visibility == VISIBLE) {
            txtChange.visibility = GONE
            txtPasswordSub.visibility = VISIBLE
            passwordCard.visibility = GONE
        } else {
            txtChange.visibility = VISIBLE
            txtPasswordSub.visibility = GONE
            passwordCard.visibility = VISIBLE
        }
    }

    private fun toggleInfoView() {
        if (txtUpdate.visibility == VISIBLE) {
            txtUpdate.visibility = GONE
            nameCard.visibility = GONE
            dobCard.visibility = GONE
            txtPersonalSub.visibility = VISIBLE
        } else {
            txtUpdate.visibility = VISIBLE
            nameCard.visibility = VISIBLE
            dobCard.visibility = VISIBLE
            txtPersonalSub.visibility = GONE
        }
    }

    private fun updateInfo() {

    }

    private fun setDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            var date = "$dayOfMonth/$monthOfYear/$year"
            editTextDOB.setText(date)
        }, year, month, day)

        datePickerDialog.show()

    }


}
