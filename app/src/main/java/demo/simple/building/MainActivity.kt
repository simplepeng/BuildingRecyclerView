package demo.simple.building

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SwitchCompat
import demo.simple.building.databinding.ActivityMainBinding
import me.simple.building.Divider
import me.simple.ktx.dp
import me.simple.ktx.toast

class MainActivity : AppCompatActivity() {

    private var mNotifyCount = 1

    private val binding by lazy { ActivityMainBinding.inflate(this.layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gridDivider = Divider(Color.parseColor("#f3f4f8"), 10.dp)

        binding.apply {
            //注册头部
            brv.register(R.layout.item_header)
                .type("header")
                .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)

            //注册Grid布局
            brv.register(R.layout.item_grid).weightRatio(3).onBind { h ->
                h.setImage(R.id.ivItem, R.drawable.ic_qq)
                h.setText(R.id.tvItem, "QQ")
                h.setOnClick(R.id.ivItem) {
                    toast("QQ")
                }
            }.divider(gridDivider)
            brv.register(R.layout.item_grid).weightRatio(3).onBind { h ->
                h.setImage(R.id.ivItem, R.drawable.ic_wx)
                h.setText(R.id.tvItem, "WeChat")
                h.setOnClick(R.id.ivItem) {
                    toast("WeChat")
                }
            }.divider(gridDivider)
            brv.register(R.layout.item_grid).weightRatio(3).onBind { h ->
                h.setImage(R.id.ivItem, R.drawable.ic_apple)
                h.setText(R.id.tvItem, "Apple")
                h.setOnClick(R.id.ivItem) {
                    toast("Apple")
                }
            }.divider(gridDivider)

            //注册消息中心
            brv.register(R.layout.item_notify)
                .type("notify")
                .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.ic_notification)
                    holder.setText(R.id.tvTitle, "消息中心")
                    Log.d("notify", "mNotifyCount: $mNotifyCount")
                    holder.setText(R.id.tvNotifyCount, mNotifyCount.toString())
                }
                .onItemClick { holder ->
                    toast("消息中心 -- " + holder.adapterPosition)

                    mNotifyCount++
                    binding.brv.notifyItemChanged("notify")
                }

            brv.register(R.layout.item_normal)
                .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.user_liked_pin)
                    holder.setText(R.id.tvTitle, "我赞过的")
                }

            brv.register(R.layout.item_normal)
                .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.user_collectionset)
                    holder.setText(R.id.tvTitle, "收藏集")
                }

            brv.register(R.layout.item_normal)
                .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.user_buy)
                    holder.setText(R.id.tvTitle, "已购买")
                }

            brv.register(R.layout.item_normal)
                .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.tag)
                    holder.setText(R.id.tvTitle, "标签管理")
                }

            brv.register(R.layout.item_checkbox)
                .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.ic_night)
                    holder.setText(R.id.tvTitle, "夜间模式")

                    holder.getView<SwitchCompat>(R.id.scDayNight)
                        ?.setOnCheckedChangeListener { _, isChecked ->
                            toast("isChecked == $isChecked")
                        }
                }

            brv.register(R.layout.item_normal)
                .onBind { holder ->
                    holder.setImage(R.id.ivIcon, R.drawable.settings)
                    holder.setText(R.id.tvTitle, "设置")
                }
                .onItemClick { holder ->
                    toast("设置 -- " + holder.adapterPosition)
                }

            //
//            for (index in 0..10) {
//                brv.register(R.layout.item_normal)
//            }

            //一定记得要调用
            brv.build()
//            brv.buildLinear()
        }
    }

    fun addItem(view: View) {
        binding.brv.register(R.layout.item_normal, 6)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setText(R.id.tvTitle, "新添加的 -- ${holder.bindingAdapterPosition}")
            }.notifyItemInserted()
    }

}