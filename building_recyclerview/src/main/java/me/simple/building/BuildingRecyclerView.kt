package me.simple.building

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class BuildingRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val floorItems = mutableListOf<Floor>()

    /**
     *
     */
    fun getItems() = floorItems

    /**
     *
     */
    fun clearItems() {
        floorItems.clear()
    }

    /**
     *
     */
    fun register(layoutId: Int): Floor {
        val builder = Floor(layoutId)
        floorItems.add(builder)
        return builder
    }

    /**
     *
     */
    fun build(layoutManager: LayoutManager = LinearLayoutManager(context)) {
        this.addItemDecoration(BuildingItemDecoration(floorItems))
        this.layoutManager = layoutManager
        this.adapter = BuildingAdapter(floorItems)
    }

    /**
     *
     */
    fun buildLinear() {
        build(LinearLayoutManager(context))
    }

    /**
     *
     */
    fun buildGrid(spanCount: Int) {
        build(GridLayoutManager(context, spanCount))
    }

    @Deprecated("方法名不合理", ReplaceWith(expression = "notifyItemChanged()"))
    fun notifyItemChangeByType(type: String) {
        (adapter as BuildingAdapter).notifyItemChangedByType(type)
    }

    /**
     * 根据注册的type更新对应的ViewHolder
     */
    fun notifyItemChanged(type: String) {
        (adapter as BuildingAdapter).notifyItemChangedByType(type)
    }

    /**
     *
     */
    fun notifyDataSetChanged() {
        adapter?.notifyDataSetChanged()
    }

    /**
     * 根据注册的type找到对应的ViewHolder
     */
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