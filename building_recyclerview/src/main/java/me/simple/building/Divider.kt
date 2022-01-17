package me.simple.building

import android.graphics.Color

data class Divider(
    val color: Int = COLOR,
    val size: Int = SIZE,
    val paddingLeft: Int = PADDING_LEFT,
    val paddingRight: Int = PADDING_RIGHT
) {
    companion object {
        const val PADDING_LEFT = 0
        const val PADDING_RIGHT = 0
        const val COLOR = Color.LTGRAY
        const val SIZE = 1
    }
}