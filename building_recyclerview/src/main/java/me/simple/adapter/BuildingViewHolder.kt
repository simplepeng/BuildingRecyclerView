package me.simple.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BuildingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        setIsRecyclable(false)
    }
}