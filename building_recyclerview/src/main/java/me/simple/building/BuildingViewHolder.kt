package me.simple.building

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class BuildingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewMap = hashMapOf<Int, View>()

    init {
        //这个属性奇怪，好好研究
//        setIsRecyclable(false)
    }

    @Suppress("UNCHECKED_CAST")
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