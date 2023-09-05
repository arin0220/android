package com.example.rollingpaper

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity // AppCompatActivity import 추가
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() { // AppCompatActivity를 상속받아야 함
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)

        val buttonAdd = findViewById<Button>(R.id.button2)
        val buttonRemove = findViewById<Button>(R.id.button)
        recyclerView = findViewById(R.id.rv_profile)

        // RecyclerView 설정 및 어댑터 초기화
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter()
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener(View.OnClickListener {
            // RecyclerView에 아이템 추가
            val newItem = "New Item" // 원하는 내용으로 변경
            adapter.addItem(newItem)
        })

        buttonRemove.setOnClickListener(View.OnClickListener {
            // RecyclerView에서 아이템 삭제
            if (adapter.itemCount > 0) {
                adapter.removeItem(0) // 첫 번째 아이템 삭제 (원하는 위치를 지정할 수 있음)
            }
        })
    }
}
