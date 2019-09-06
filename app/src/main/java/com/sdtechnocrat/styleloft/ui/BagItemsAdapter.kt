package com.sdtechnocrat.styleloft.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.list_bag_items.view.*

class BagItemsAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<BigItemViewHolder>() {

    override fun getItemCount(): Int {
        //return items.size
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigItemViewHolder {
        return BigItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_bag_items, parent, false))
    }

    override fun onBindViewHolder(holder: BigItemViewHolder, position: Int) {
        //holder.txtOrderNumer.text = items.get(position)
        //holder.detailsBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_ordersFragment_to_orderDetails))
        holder.viewMoreFrame.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(context, holder.viewMoreFrame)
            popupMenu.menuInflater.inflate(R.menu.bag_popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.add_to_fav ->
                        Toast.makeText(context, "Item " + position + " added to favorites", Toast.LENGTH_SHORT).show()
                    R.id.delete_from_list ->
                        Toast.makeText(context, "Item " + position + " removed from list", Toast.LENGTH_SHORT).show()
                }
                true
            }
            popupMenu.show()
        }


        holder.addFrame.setOnClickListener {
            var itemCount : CharSequence = holder.txtItemCount.text
            var count = itemCount.toString()
            var items = count.toInt()
            if (items < 10) {
                items++
            }
            holder.txtItemCount.text = items.toString()
        }

        holder.removeFrame.setOnClickListener {
            var itemCount : CharSequence = holder.txtItemCount.text
            var count = itemCount.toString()
            var items = count.toInt()
            if (items > 1) {
                items--
            }
            holder.txtItemCount.text = items.toString()
        }
    }
}

class  BigItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val txtItemName : TextView = view.txtItemName
    val viewMoreFrame : FrameLayout = view.viewMoreFrame
    val removeFrame : FrameLayout = view.removeFrame
    val addFrame : FrameLayout = view.addFrame
    val txtItemCount : TextView = view.txtItemCount
}