package com.sdtechnocrat.styleloft.checkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.item_list_delivery_method.view.*

class DeliveryMethodsAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<DeliveryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryItemViewHolder {
        return DeliveryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_delivery_method, parent, false))
    }

    override fun getItemCount(): Int {
        //return items.size
        return 3
    }

    override fun onBindViewHolder(holder: DeliveryItemViewHolder, position: Int) {
        //holder.txtOrderNumer.text = items.get(position)
        var layoutParams : FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        if (position == 0) {
            layoutParams.marginStart = 60

        } else if (position == 2) {
            layoutParams.marginStart = 40
            layoutParams.marginEnd = 60
        } else {
            layoutParams.marginStart = 40
        }

        holder.frameLayout.layoutParams = layoutParams

        holder.linearLayout.setOnClickListener {

        }

    }

}

class DeliveryItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val estimatedTime : TextView = view.estimatedTime
    val deliveryProvider : ImageView = view.deliveryProvider
    val frameLayout : FrameLayout = view.frameLayout
    val linearLayout : LinearLayout = view.linearLayout
}