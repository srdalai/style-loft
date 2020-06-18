package com.sdtechnocrat.styleloft.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sdtechnocrat.styleloft.R
import kotlinx.android.synthetic.main.item_favorite_list_layout.view.*
import kotlinx.android.synthetic.main.list_bag_items.view.*
import kotlinx.android.synthetic.main.list_bag_items.view.imageViewItem

class FavoritesAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun getItemCount(): Int {
        //return items.size
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_favorite_list_layout, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.imageViewItem.visibility = VISIBLE
        if (position == 0) {
            holder.parentFrame.foreground = context.resources.getDrawable(R.color.transparent, null)
            holder.addToBasketFrame.visibility = VISIBLE
            holder.txtNotAvailable.visibility = GONE
        } else {
            holder.parentFrame.foreground = context.resources.getDrawable(R.color.trans_white, null)
            holder.addToBasketFrame.visibility = GONE
            holder.txtNotAvailable.visibility = VISIBLE
        }
    }
}

class FavoriteViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val imageViewItem : ImageView = view.imageViewItem
    val parentFrame : FrameLayout = view.parentFrame
    val addToBasketFrame : FrameLayout = view.addToBasketFrame
    val txtNotAvailable : TextView = view.txtNotAvailable
}