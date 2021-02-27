package com.misakikawaguchi.recyclerviewsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbarを取得
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // ツールバーにロゴを設定
        toolbar.setLogo(R.mipmap.ic_launcher)
        // アクションバーにツールバーを設定
        setSupportActionBar(toolbar)

        // CollapsingToolbarLayoutを取得
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbarLayout)
        // タイトルを設定
        toolbarLayout.title = getString(R.string.toolbar_title)
        // 通常サイズ時の文字色を設定
        toolbarLayout.setExpandedTitleColor(Color.WHITE)
        // 縮小サイズ時の文字色を設定
        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY)
    }

    // リストビューに表示させる定食リストデータを生成するメソッド
    private fun createTeishoku(): MutableList<MutableMap<String, Any>> {
        // 定食メニューリスト用のListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

        //「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf("name" to "から揚げ定食", "price" to 800, "desc" to "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 800, "desc" to "ハンバーグにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "生姜焼き定食", "price" to 800, "desc" to "生姜焼きにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to 800, "desc" to "ステーキにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to 800, "desc" to "野菜炒めにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to 800, "desc" to "とんかつにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチカツ定食", "price" to 800, "desc" to "ミンチカツにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカツ定食", "price" to 800, "desc" to "チキンカツにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to 800, "desc" to "コロッケにサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to 800, "desc" to "焼き魚にサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼肉定食", "price" to 800, "desc" to "焼肉にサラダ、ご飯とお味噌汁がつきます")
        menuList.add(menu)

        return menuList
    }

    // RecyclerViewのビューホルダクラス
    private inner class RecyclerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // リスト1行分中でメニュー名を表示する画面部品
        var tvMenuName: TextView
        // リスト1行分中でメニュー金額を表示する画面部品
        var tvMenuPrice: TextView

        init {
            // 引数で渡されたリスト1行分の画面部品中から表示に使われるTextViewを取得
            tvMenuName = itemView.findViewById(R.id.tvMenuName)
            tvMenuPrice = itemView.findViewById(R.id.tvMenuPrice)
        }
    }
}