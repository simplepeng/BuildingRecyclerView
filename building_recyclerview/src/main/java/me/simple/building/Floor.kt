package me.simple.building


open class Floor(internal val layoutId: Int) {

    internal var type = ""

    internal var divider: Divider? = null

    internal var onBindBlock: ((holder: BuildingViewHolder) -> Unit)? = null

    internal var onItemClick: ((holder: BuildingViewHolder) -> Unit)? = null

    internal var recyclable: Boolean = true

    internal var weightNum: Int = 1

    /**
     * 注册ItemView的类型
     */
    fun type(type: String): Floor {
        this.type = type
        return this
    }

    /**
     * 分割线
     */
    fun divider(divider: Divider): Floor {
        this.divider = divider
        return this
    }

    fun divider(
        color: Int = Divider.COLOR,
        size: Int = Divider.SIZE,
        paddingLeft: Int = Divider.PADDING_LEFT,
        paddingRight: Int = Divider.PADDING_RIGHT
    ): Floor {
        divider(Divider(color, size, paddingLeft, paddingRight))
        return this
    }

    fun divider(
        color: Int = Divider.COLOR,
        size: Int = Divider.SIZE,
        padding: Int = Divider.PADDING_LEFT
    ): Floor {
        divider(Divider(color, size, padding, padding))
        return this
    }

    /**
     * onBindViewHolder回调
     */
    fun onBind(block: (holder: BuildingViewHolder) -> Unit): Floor {
        this.onBindBlock = block
        return this
    }

    /**
     * ItemView OnClick回调
     */
    fun onItemClick(onItemClick: (holder: BuildingViewHolder) -> Unit): Floor {
        this.onItemClick = onItemClick
        return this
    }

    fun recyclable(recyclable: Boolean): Floor {
        this.recyclable = recyclable
        return this
    }

    /**
     *
     */
    fun weightNum(num: Int): Floor {
        this.weightNum = num
        return this
    }
}