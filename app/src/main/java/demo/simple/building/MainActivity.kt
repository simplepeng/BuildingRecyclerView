package demo.simple.building

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SwitchCompat
import demo.simple.building.databinding.ActivityMainBinding
import me.simple.ktx.dp
import me.simple.ktx.toast

class MainActivity : AppCompatActivity() {

    private var mNotifyCount = 1

    private val binding by lazy { ActivityMainBinding.inflate(this.layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //注册头部
        binding.brv.register(R.layout.item_header)
            .type("header")
            .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)

        //注册消息中心
        binding.brv.register(R.layout.item_notify)
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
                binding.brv.notifyItemChangeByType("notify")
            }

        binding.brv.register(R.layout.item_normal)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.user_liked_pin)
                holder.setText(R.id.tvTitle, "我赞过的")
            }

        binding.brv.register(R.layout.item_normal)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.user_collectionset)
                holder.setText(R.id.tvTitle, "收藏集")
            }

        binding.brv.register(R.layout.item_normal)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.user_buy)
                holder.setText(R.id.tvTitle, "已购买")
            }

        binding.brv.register(R.layout.item_normal)
            .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.tag)
                holder.setText(R.id.tvTitle, "标签管理")
            }

        binding.brv.register(R.layout.item_checkbox)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.ic_night)
                holder.setText(R.id.tvTitle, "夜间模式")

                holder.getView<SwitchCompat>(R.id.scDayNight)
                    ?.setOnCheckedChangeListener { _, isChecked ->
                        toast("isChecked == $isChecked")
                    }
            }

        binding.brv.register(R.layout.item_normal)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.settings)
                holder.setText(R.id.tvTitle, "设置")
            }
            .onItemClick { holder ->
                toast("设置 -- " + holder.adapterPosition)
            }

        //一定记得要调用
        binding.brv.build()
    }

}