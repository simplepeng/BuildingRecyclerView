package me.simple.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuildingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewMap = hashMapOf<Int, View>()

    init {
        setIsRecyclable(false)
    }

    fun setText(id: Int, text: String) {
        var textView: TextView? = viewMap[id] as? TextView
        if (textView == null) {
            textView = itemView.findViewById(id)
            viewMap[id] = textView
        }
        textView?.text = text
    }

    fun setText(id: Int, resId: Int) {
        var textView: TextView? = viewMap[id] as? TextView
        if (textView == null) {
            textView = itemView.findViewById(id)
            viewMap[id] = textView
        }
        textView?.setText(resId)
    }

    fun setImage(id: Int, resId: Int) {
        var imageView: ImageView? = viewMap[id] as? ImageView
        if (imageView == null) {
            imageView = itemView.findViewById(id)
            viewMap[id] = imageView
        }
        imageView?.setImageResource(resId)
    }
}