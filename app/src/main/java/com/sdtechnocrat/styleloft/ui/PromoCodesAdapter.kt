package com.sdtechnocrat.styleloft.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdtechnocrat.styleloft.R

class PromoCodesAdapter(val itemList: ArrayList<String>, val mContext: Context) : RecyclerView.Adapter<AddressItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressItemViewHolder {
        return AddressItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_promocodes, parent, false))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: AddressItemViewHolder, position: Int) {
    }

}

class AddressItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //val txtName : TextView = view.txtName
}