package me.simple.building

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BuildingLayoutManger(
    private val context: Context,
    private val floorItems: MutableList<Floor>
) : RecyclerView.LayoutManager() {

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    override fun isAutoMeasureEnabled(): Boolean {
        return true
    }

    override fun onLayoutChildren(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ) {
        Log.d("BuildingLayoutManger", "onLayoutChildren")
        if (state.itemCount == 0) {
            removeAndRecycleAllViews(recycler)
            return
        }
        if (state.isPreLayout) {
            return
        }
        detachAndScrapAttachedViews(recycler)
        fillChildren(recycler)
    }

    override fun onLayoutCompleted(state: RecyclerView.State) {

    }

    override fun canScrollVertically(): Boolean {
        return true
    }

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int {
        val offset = getOffset(dy)
        if (offset != 0) {
            offsetChildrenVertical(-offset)
        }
        return offset
    }

    private fun getOffset(dy: Int): Int {
        Log.d("BuildingLayoutManger", dy.toString())
        if (dy > 0) {
            val anchor = getChildAt(childCount - 1) ?: return dy
            val bottom = getDecoratedBottom(anchor)
            if (bottom <= height) return bottom - height
        }
        if (dy < 0) {
            val anchor = getChildAt(0) ?: return dy
            val top = getDecoratedTop(anchor)
            if (top >= 0) return top
        }
        return dy
    }

    private fun fillChildren(recycler: RecyclerView.Recycler) {
        var left = 0
        var top = 0
        var right = 0
        var bottom = 0
        var maxItemHeight = 0//一行最大的item高度
        var linearWidth = 0//水平方向占用了的宽度

        floorItems.forEachIndexed { index, floor ->
            val itemWidth = width / floor.weightNum

            val itemView = recycler.getViewForPosition(index)
            addView(itemView)
            measureChildWithMargins(itemView, 0, 0)
            measureChildren(itemView, itemWidth)

            if (left + itemWidth > width) {
                linearWidth = 0
                left = 0
                top = maxItemHeight
            }
            right = left + getDecoratedMeasuredWidth(itemView)
            bottom = top + getDecoratedMeasuredHeight(itemView)

            layoutDecoratedWithMargins(itemView, left, top, right, bottom)

            left = right
            if (bottom > maxItemHeight) {
                maxItemHeight = bottom
            }
            linearWidth += itemWidth

        }
    }

    private fun measureChildren(
        itemView: View,
        itemWidth: Int
    ) {
        val lp = itemView.layoutParams as RecyclerView.LayoutParams

        val widthPadding = paddingStart + paddingEnd + lp.leftMargin + lp.rightMargin
        val widthSpec = getChildMeasureSpec(
            itemWidth,
            View.MeasureSpec.EXACTLY,
            widthPadding,
            lp.width,
            canScrollHorizontally()
        )
        val heightPadding = paddingTop + paddingBottom + lp.topMargin + lp.bottomMargin
        val heightSpec = getChildMeasureSpec(
            height,
            heightMode,
            heightPadding,
            lp.height,
            canScrollVertically()
        )

        itemView.measure(widthSpec, heightSpec)
    }
}