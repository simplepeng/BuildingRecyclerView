package me.simple.building

import android.graphics.Color

data class Divider(

    val paddingLeft: Int = PADDING_LEFT,
    val paddingRight: Int = PADDING_RIGHT,
    val color: Int = COLOR,
    val size: Int = SIZE

) {
    companion object {
        const val PADDING_LEFT = 0
        const val PADDING_RIGHT = 0
        const val COLOR = Color.LTGRAY
        const val SIZE = 1
    }
}