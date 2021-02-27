package com.misakikawaguchi.recyclerviewsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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

        // リサイクラービューのデータ表示処理
        // RecyclerViewを取得
        val lvMenu = findViewById<RecyclerView>(R.id.lvMenu)
        // LinearLayoutManagerオブジェクトを生成
        val layout = LinearLayoutManager(applicationContext)
        // RecyclerViewにレイアウトマネージャーとしてLinearLayoutManagerを設定
        lvMenu.layoutManager = layout

        // 定食メニューリストデータを生成
        val menuList = createTeishokuList()
        // アダプタオブジェクトを生成
        val adapter = RecyclerListAdapter(menuList)
        // RecyclerViewにアダプタオブジェクトを設定
        lvMenu.adapter = adapter

        // 区切り専用のオブジェクトを生成
        val decorator = DividerItemDecoration(applicationContext, layout.orientation)
        // RecyclerViewに区切り線オブジェクトを設定
        lvMenu.addItemDecoration(decorator)
    }

    // リストビューに表示させる定食リストデータを生成するメソッド
    private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
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

    // RecyclerViewのアダプタクラス
    private inner class RecyclerListAdapter(private val _listData: MutableList<MutableMap<String, Any>>): RecyclerView.Adapter<RecyclerListViewHolder>() {

        // ビューホルダオブジェクトを生成するメソッド
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerListViewHolder {
            //レイアウトインフレータを取得。
            val inflater = LayoutInflater.from(applicationContext)
            //row.xmlをインフレートし、1行分の画面部品とする。
            val view = inflater.inflate(R.layout.row, parent, false)
            //ビューホルダオブジェクトを生成。
            val holder = RecyclerListViewHolder(view)
            //生成したビューホルダをリターン。
            return holder
        }

        // ビューホルダ内の各画面部品に表示データを割り当てるメソッド
        override fun onBindViewHolder(holder: RecyclerListViewHolder, position: Int) {
            // リストデータから該当1行分のデータを取得
            val item = _listData[position]
            // メニュー名文字列を取得
            val menuName = item["name"] as String
            // メニュー金額を取得
            val menuPrice = item["price"] as Int
            // 表示用に金額を文字列に変換
            val menuPriceStr = menuPrice.toString()

            // メニュー名と金額をビューホルダ生のTextViewに設定
            holder.tvMenuName.text = menuName
            holder.tvMenuPrice.text = menuPriceStr
        }

        // データ件数を返すメソッド
        override fun getItemCount(): Int {
            // リストデータ中の件数をリターン
            return _listData.size
        }
    }
}

