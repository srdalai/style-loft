package com.sdtechnocrat.styleloft.checkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.item_list_payment_cards.view.*

class PaymentMethodsAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<PaymentItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentItemViewHolder {
        return PaymentItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_payment_cards, parent, false))
    }

    override fun getItemCount(): Int {
        //return items.size
        return 6
    }

    override fun onBindViewHolder(holder: PaymentItemViewHolder, position: Int) {
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

        //holder.frameLayout.layoutParams = layoutParams
        holder.txtCardNum.letterSpacing = 0.4f

    }

}

class PaymentItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //val frameLayout : FrameLayout = view.frameLayout
    //val linearLayout : LinearLayout = view.linearLayout
    val txtCardNum : TextView = view.txtCardNum
}