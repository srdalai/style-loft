package com.sdtechnocrat.styleloft.checkout

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.sdtechnocrat.styleloft.R
import com.sdtechnocrat.styleloft.model.AddressData
import kotlinx.android.synthetic.main.list_item_address.view.*

class AddressAdapter (val items : ArrayList<AddressData>, val context: Context, val activity: Activity) : RecyclerView.Adapter<AddressItemViewHolder>() {
    var previousSelectedPosn: Int = 0;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressItemViewHolder {
        return AddressItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_address, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AddressItemViewHolder, position: Int) {
        var addressData = items[position]
        holder.txtName.text = addressData.fullName
        val addTwo = addressData.addressTwo + ", " + addressData.city + " - " + addressData.zip
        holder.txtAddressOne.text = addressData.addressOne
        holder.txtAddressRwo.text = addTwo

        holder.checkBox.isChecked = addressData.isSelected

        holder.parentRelative.setOnClickListener {
            Log.d("TAG", addressData.isSelected.toString())
            if (!addressData.isSelected) {
                addressData.isSelected = true
                items[previousSelectedPosn].isSelected = false
                previousSelectedPosn = position
                notifyDataSetChanged()
            }
        }

        holder.addressEditBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("fullName", addressData.fullName)
            bundle.putString("addressOne", addressData.addressOne)
            bundle.putString("addressTwo", addressData.addressTwo)
            bundle.putString("city", addressData.city)
            bundle.putString("state", addressData.state)
            bundle.putString("zip", addressData.zip)
            bundle.putString("country", addressData.country)
            bundle.putBoolean("hasAddress", true)
            Navigation.findNavController(activity,R.id.nav_host_fragment).navigate(R.id.action_selectAddress_to_addAddress,bundle)

        }
    }

}

class AddressItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val txtName : TextView = view.txtName
    val addressEditBtn : MaterialButton = view.addressEditBtn
    val txtAddressOne : TextView = view.txtAddressOne
    val txtAddressRwo : TextView = view.txtAddressRwo
    val parentRelative : RelativeLayout = view.parentRelative
    val checkBox : CheckBox = view.checkBox
}