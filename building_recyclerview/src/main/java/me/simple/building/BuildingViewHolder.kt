package me.simple.building

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuildingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewMap = hashMapOf<Int, View>()

    init {
        setIsRecyclable(false)
    }

    fun <T : View> getView(id: Int): T? {
        var view: T? = viewMap[id] as? T
        if (view == null) {
            view = itemView.findViewById(id)
            viewMap[id] = view
        }
        return view
    }

    fun setText(id: Int, text: String) {
        val textView: TextView? = getView(id)
        textView?.text = text
    }

    fun setText(id: Int, resId: Int) {
        val textView: TextView? = getView(id)
        textView?.setText(resId)
    }

    fun setImage(id: Int, resId: Int) {
        val imageView: ImageView? = getView(id)
        imageView?.setImageResource(resId)
    }
}