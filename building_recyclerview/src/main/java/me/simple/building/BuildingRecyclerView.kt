package me.simple.building

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuildingRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val floorItems = mutableListOf<Floor>()

    fun register(layoutId: Int): Floor {
        val builder = Floor(layoutId)
        floorItems.add(builder)
        return builder
    }

    fun build() {
        addItemDecoration(BuildingItemDecoration(floorItems))
        layoutManager = LinearLayoutManager(context)
        adapter = BuildingAdapter(floorItems)
    }

    @Deprecated("方法名不合理", ReplaceWith(expression = "notifyItemChanged()"))
    fun notifyItemChangeByType(type: String) {
        (adapter as BuildingAdapter).notifyItemChangedByType(type)
    }

    fun notifyItemChanged(type: String) {
        (adapter as BuildingAdapter).notifyItemChangedByType(type)
    }

    fun notifyDataSetChanged() {
        adapter?.notifyDataSetChanged()
    }

    fun findViewHolder(type: String): BuildingViewHolder? {
        var viewHolder: BuildingViewHolder? = null

        floorItems.forEachIndexed { index, floor ->
            if (floor.type == type) {
                viewHolder = findViewHolderForAdapterPosition(index) as? BuildingViewHolder
            }
        }

        return viewHolder
    }
}