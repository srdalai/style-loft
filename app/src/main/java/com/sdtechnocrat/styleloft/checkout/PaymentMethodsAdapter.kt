package com.sdtechnocrat.styleloft.checkout

import android.content.Context
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.sdtechnocrat.styleloft.R
import com.sdtechnocrat.styleloft.model.PaymentMethodData
import kotlinx.android.synthetic.main.item_list_payment_cards.view.*

class PaymentMethodsAdapter(val items : ArrayList<PaymentMethodData>, val context: Context) : RecyclerView.Adapter<PaymentItemViewHolder>() {

    var previousSelectedPosn: Int = 0;
    var previousDefaultPosn: Int = 0;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentItemViewHolder {
        return PaymentItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_payment_cards, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PaymentItemViewHolder, position: Int) {
        /*var layoutParams : FrameLayout.LayoutParams = FrameLayout.LayoutParams(
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
        }*/

        var paymentMethodData = items[position]



        holder.txtCardNum.letterSpacing = 0.1f

        if (paymentMethodData.isSelected) {
            holder.foregroundFrame.visibility = GONE
            holder.checkBox.isChecked = true;

        } else {
            holder.foregroundFrame.visibility = VISIBLE
            holder.checkBox.isChecked = false;
        }


        holder.cardView.setOnClickListener{
            Log.d("TAG", paymentMethodData.isSelected.toString())
            if (!paymentMethodData.isSelected) {
                paymentMethodData.isSelected = true
                items[previousSelectedPosn].isSelected = false
                previousSelectedPosn = position
                notifyDataSetChanged()
            }
        }

        holder.checkBoxFrame.setOnClickListener {
            Log.d("TAG", paymentMethodData.isSelected.toString())
            if (!paymentMethodData.isSelected) {
                paymentMethodData.isSelected = true
                items[previousSelectedPosn].isSelected = false
                previousSelectedPosn = position
                notifyDataSetChanged()
            } else {
                holder.checkBox.isSelected = false
            }
        }

    }

}

class PaymentItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val txtCardNum : TextView = view.txtCardNum
    val foregroundFrame : FrameLayout = view.foregroundFrame
    val cardView : MaterialCardView = view.cardView
    val checkBox : CheckBox = view.checkBox
    val checkBoxFrame : FrameLayout = view.checkBoxFrame
}