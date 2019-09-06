package com.sdtechnocrat.styleloft.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.list_items_order_details.view.*

class ItemsOrderAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun getItemCount(): Int {
        //return items.size
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items_order_details, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //holder.txtOrderNumer.text = items.get(position)
        //holder.detailsBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_ordersFragment_to_orderDetails))
    }
}

class ItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val imageViewItem : ImageView = view.imageViewItem
}