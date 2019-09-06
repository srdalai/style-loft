package com.sdtechnocrat.styleloft.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.list_order_item.view.*

class OrdersAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<OrderViewHolder>() {

    override fun getItemCount(): Int {
        //return items.size
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(LayoutInflater.from(context).inflate(R.layout.list_order_item, parent, false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        //holder.txtOrderNumer.text = items.get(position)
        holder.detailsBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_ordersFragment_to_orderDetails))
    }
}

class OrderViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val txtOrderNumer : TextView = view.txtOrderNumer
    val txtOrderDate : TextView = view.txtOrderDate
    val txtTrackingNumber : TextView = view.txtTrackingNumber
    val txtQuantity : TextView = view.txtQuantity
    val txtAmount : TextView = view.txtAmount
    val txtStatus : TextView = view.txtStatus
    val detailsBtn : MaterialButton = view.detailsBtn
}