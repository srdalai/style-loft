package com.sdtechnocrat.styleloft.auth


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sdtechnocrat.styleloft.MainActivity

import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.fragment_signup.*

/**
 * A simple [Fragment] subclass.
 */
class Signup : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Siginig you up...")

        loginRelative.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_signup_to_nav_login))

        signupBtn.setOnClickListener{
            progressDialog.show()
            Handler().postDelayed({
                progressDialog.dismiss()
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            }, 5000)
        }
    }
}
