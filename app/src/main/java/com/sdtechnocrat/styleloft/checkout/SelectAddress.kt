package com.sdtechnocrat.styleloft.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.sdtechnocrat.styleloft.R
import com.sdtechnocrat.styleloft.model.AddressData
import kotlinx.android.synthetic.main.fragment_select_address.*

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

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Select Addresses"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addressRecycler.layoutManager = LinearLayoutManager(requireContext())
        addressRecycler.adapter = AddressAdapter(prepareAddress(), requireContext(), requireActivity())

        fabAdd.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_selectAddress_to_addAddress))
    }

    private fun prepareAddress():ArrayList<AddressData> {
        val dataList = ArrayList<AddressData>()
        dataList.add(AddressData("Satyaranjan Dalai", "Madhubana 1st Lane", "Nabakalebara Road","Puri", "Odisha","752002", "IN", true))
        dataList.add(AddressData("Satyaranjan Dalai", "205 - Siddhi Vinayk Residency, Mahadev Nagar", "Jharpada","Bhubaneswar", "Odisha","751006", "IN", false))
        dataList.add(AddressData("Satyaranjan Dalai", "B - 6/12, Berhampur University", "Bhanja Vihar","Berhampur", "Odisha","760006", "IN", false))
        dataList.add(AddressData("Satyaranjan Dalai", "RB - IV/4, Bapuji Nagar", "Near Adivasi Ground","Bhubaneswar", "Odisha","751001", "IN", false))
        dataList.add(AddressData("Satyaranjan Dalai", "Muvi, 3rd Floor, IDCO Tower Mini", "Mancheswar","Bhubaneswar", "Odisha","751010", "IN", false))
        return dataList
    }


}
