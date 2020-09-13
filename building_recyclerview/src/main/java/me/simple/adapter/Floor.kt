package me.simple.adapter

import android.graphics.Color

class Floor(val layoutId: Int) {

    var type = ""
    var divider: Divider? = null
    var onBindBlock: ((holder: BuildingViewHolder) -> Unit)? = null
    var onItemClick: ((holder: BuildingViewHolder) -> Unit)? = null

    fun type(type: String): Floor {
        this.type = type
        return this
    }

    fun divider(divider: Divider): Floor {
        this.divider = divider
        return this
    }

    fun divider(
        paddingLeft: Int,
        paddingRight: Int,
        color: Int,
        size: Int
    ): Floor {
        divider(Divider(paddingLeft, paddingRight, color, size))
        return this
    }

    fun divider(
        padding: Int = 0,
        color: Int = Color.BLACK,
        size: Int = 1
    ): Floor {
        divider(Divider(padding, padding, color, size))
        return this
    }

    fun onBind(block: (holder: BuildingViewHolder) -> Unit): Floor {
        this.onBindBlock = block
        return this
    }

    fun onItemClick(onItemClick: (holder: BuildingViewHolder) -> Unit): Floor {
        this.onItemClick = onItemClick
        return this
    }
}