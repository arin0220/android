package com.example.rollingpaper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recyclerView_content : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_content)

        recyclerView = findViewById(R.id.rv_profile)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // SharedPreferences에서 데이터를 가져옵니다.
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val nameText = sharedPreferences.getString("nameText", "")
        val contentText = sharedPreferences.getString("contentText", "")

        // MyRecyclerViewAdapter로 변경
        adapter = MyRecyclerViewAdapter(nameText, contentText)
        recyclerView.adapter = adapter
    }

    class CustomAdapter(private val nameText: String?, private val contentText: String?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            // 뷰 홀더 내에서 UI 요소에 대한 참조를 초기화할 수 있습니다.
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val contentTextView: TextView = view.findViewById(R.id.contentTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // 새 뷰 홀더를 생성하고 반환합니다.
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // 뷰 홀더에 데이터를 바인딩합니다.
            holder.nameTextView.text = nameText
            holder.contentTextView.text = contentText
        }

        override fun getItemCount(): Int {
            return 1 // 데이터가 하나뿐이므로 아이템 수는 1입니다.
        }
    }

}
