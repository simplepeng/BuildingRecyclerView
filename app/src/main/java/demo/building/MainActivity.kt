package demo.building

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.simple.ktx.dp
import me.simple.ktx.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.register(R.layout.item_header)
            .type("header")
            .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)

        recyclerView.register(R.layout.item_normal)
            .divider(paddingLeft = 20.dp, color = Color.LTGRAY)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.ic_notification)
                holder.setText(R.id.tvTitle, "消息中心")
            }
            .onItemClick { holder ->
                toast("消息中心 -- " + holder.adapterPosition)
            }

        recyclerView.register(R.layout.item_normal).onBind { holder ->
            holder.setImage(R.id.ivIcon, R.drawable.user_liked_pin)
            holder.setText(R.id.tvTitle, "我赞过的")
        }

        recyclerView.register(R.layout.item_normal).onBind { holder ->
            holder.setImage(R.id.ivIcon, R.drawable.user_collectionset)
            holder.setText(R.id.tvTitle, "收藏集")
        }

        recyclerView.register(R.layout.item_normal).onBind { holder ->
            holder.setImage(R.id.ivIcon, R.drawable.user_buy)
            holder.setText(R.id.tvTitle, "已购买")
        }

        recyclerView.register(R.layout.item_normal)
            .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.tag)
                holder.setText(R.id.tvTitle, "标签管理")
            }

        recyclerView.register(R.layout.item_checkbox)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.ic_night)
                holder.setText(R.id.tvTitle, "夜间模式")
            }

        recyclerView.register(R.layout.item_normal)
            .onBind { holder ->
                holder.setImage(R.id.ivIcon, R.drawable.settings)
                holder.setText(R.id.tvTitle, "设置")
            }
            .onItemClick { holder ->
                toast("设置 -- " + holder.adapterPosition)
            }


        recyclerView.build()
    }

}