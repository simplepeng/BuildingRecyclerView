package me.simple.adapter

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class BuildingItemDecoration(private val floorItems: MutableList<Floor>) :
    RecyclerView.ItemDecoration() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dividerRect = Rect()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.layoutManager == null) return
        if (parent.adapter == null) return
        if (parent.adapter!!.itemCount == 0) return
        if (floorItems.isEmpty()) return

        var dividerSize = 0
        for (floor in floorItems) {
            if (floor.divider == null) continue
            dividerSize = floor.divider!!.size
            outRect.set(0, 0, 0, dividerSize)
        }
    }

    override fun onDraw(
        canvas: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.onDraw(canvas, parent, state)
        if (parent.layoutManager == null) return
        if (parent.adapter == null) return
        if (parent.adapter!!.itemCount == 0) return
        if (floorItems.isEmpty()) return

        val bounds = Rect()
        floorItems.forEachIndexed { index, floor ->
            if (floor.divider != null) {
                val divider = floor.divider!!
                val itemView = parent.getChildAt(index)
                parent.getDecoratedBoundsWithMargins(itemView, bounds)

                val bottom: Int = bounds.bottom + itemView.translationY.roundToInt()
                val top: Int = bottom - divider.size
                val left = divider.paddingLeft
                val right = bounds.right - divider.paddingRight
                dividerRect.set(left, top, right, bottom)

                paint.color = divider.color
                canvas.drawRect(dividerRect, paint)
            }
        }
    }

}