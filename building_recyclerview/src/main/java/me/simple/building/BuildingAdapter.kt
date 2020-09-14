package me.simple.building

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BuildingAdapter(private val floorItems: MutableList<Floor>) :
    RecyclerView.Adapter<BuildingViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuildingViewHolder {
        val layoutId = floorItems[viewType].layoutId
        val inflater = LayoutInflater.from(parent.context)
        return BuildingViewHolder(inflater.inflate(layoutId, parent, false))
    }

    override fun getItemCount(): Int {
        return floorItems.size
    }

    override fun onBindViewHolder(
        holder: BuildingViewHolder,
        position: Int
    ) {
        val floor = floorItems[position]

        floor.onBindBlock?.invoke(holder)

        holder.itemView.setOnClickListener {
            floor.onItemClick?.invoke(holder)
        }
    }

    fun notifyItemChangeByType(type: String) {
        floorItems.forEachIndexed { index, floor ->
            if (floor.type == type) {
                this.notifyItemChanged(index)
            }
        }
    }


}