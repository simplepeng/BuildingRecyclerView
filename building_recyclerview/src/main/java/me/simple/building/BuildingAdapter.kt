package me.simple.building

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BuildingAdapter(
    private val floorItems: MutableList<Floor>
) : RecyclerView.Adapter<BuildingViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuildingViewHolder {
        val floor = floorItems[viewType]

        val layoutId = floor.layoutId
        val inflater = LayoutInflater.from(parent.context)
        val holder = BuildingViewHolder(inflater.inflate(layoutId, parent, false))
//        holder.setIsRecyclable(floor.recyclable)

        return holder
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

        floor.onItemClick?.let { block ->
            holder.itemView.setOnClickListener {
                block.invoke(holder)
            }
        }
    }

    fun notifyItemChangedByType(type: String) {
        floorItems.forEachIndexed { index, floor ->
            if (floor.type == type) {
                this.notifyItemChanged(index)
            }
        }
    }

}