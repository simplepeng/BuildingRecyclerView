package demo.building

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.register(R.layout.item_header).type("header")
            .divider(size = 10)
            .onBind { holder ->

            }
            .onItemClick { holder ->

            }

        recyclerView.register(R.layout.item_header)

        recyclerView.register(R.layout.item_header)

        recyclerView.register(R.layout.item_header)

        recyclerView.build()
    }

}