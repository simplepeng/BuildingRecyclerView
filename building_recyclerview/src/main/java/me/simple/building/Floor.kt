package me.simple.building


class Floor(val layoutId: Int) {

    internal var type = ""
    var divider: Divider? = null
    var onBindBlock: ((holder: BuildingViewHolder) -> Unit)? = null
    var onItemClick: ((holder: BuildingViewHolder) -> Unit)? = null
    internal var recyclable:Boolean = true

    fun type(type: String): Floor {
        this.type = type
        return this
    }

    fun divider(divider: Divider): Floor {
        this.divider = divider
        return this
    }

    fun divider(
        paddingLeft: Int = Divider.PADDING_LEFT,
        paddingRight: Int = Divider.PADDING_RIGHT,
        color: Int = Divider.COLOR,
        size: Int = Divider.SIZE
    ): Floor {
        divider(Divider(paddingLeft, paddingRight, color, size))
        return this
    }

    fun divider(
        padding: Int = Divider.PADDING_LEFT,
        color: Int = Divider.COLOR,
        size: Int = Divider.SIZE
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

    fun recyclable(recyclable:Boolean){
        this.recyclable = recyclable
    }
}