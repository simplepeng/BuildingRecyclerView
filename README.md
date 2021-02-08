# BuildingRecyclerView

[![](https://www.jitpack.io/v/simplepeng/BuildingRecyclerView.svg)](https://www.jitpack.io/#simplepeng/BuildingRecyclerView)

像修建楼房一样使用`RecyclerView`，其实主要是用`RecyclerView`来写`个人页面`、`设置页面`那种布局。

相比较`ScrollView`那种写法的优点：`方便增删Item`，`方便更新Item`，`不用写那么多id`，`方便配置不同的Divider`

以前我是用`MultiType`写这种布局，每次都要写`Items`的数据源，以及更新也挺麻烦的，`MultiType`是把`牛刀`，这种布局就是`BuildingRecyclerView`就够了。

![BuildingRecyclerView](https://i.loli.net/2020/09/14/FRy2GhTku7DPglr.png)

## 导入依赖

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

```groovy
implementation 'com.github.simplepeng:BuildingRecyclerView:v1.0.1'
```

## 使用

```xml
    <me.simple.building.BuildingRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

```kotlin
        //注册头部
        recyclerView.register(R.layout.item_header)
            .type("header")
            .divider(color = Color.parseColor("#f3f4f8"), size = 10.dp)

        //注册消息中心
        recyclerView.register(R.layout.item_notify)
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
                recyclerView.notifyItemChangeByType("notify")
            }

				...

        //一定记得要调用
        recyclerView.build()
```

完整使用示例：[Example](https://github.com/simplepeng/BuildingRecyclerView/blob/master/app/src/main/java/demo/building/MainActivity.kt)

### 更新Item

```kotlin
recyclerView.notifyItemChanged("notify")
```

`type`	就是`register`后传入的那个`type`。

## 版本迭代

* 增加`findViewHolder`方法，修改notifyType方法名。

* v1.0.0：首次上传。