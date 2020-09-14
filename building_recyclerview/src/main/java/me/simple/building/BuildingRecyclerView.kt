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

    fun notifyItemChangeByType(type: String) {
        (adapter as BuildingAdapter).notifyItemChangeByType(type)
    }
}