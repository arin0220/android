package com.example.rollingpaper

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : Activity() {
    private lateinit var nameEditText: EditText // 이름을 입력하는 EditText
    private lateinit var menuEditText: EditText // 메뉴를 입력하는 EditText
    private lateinit var numEditText: EditText // 인원수를 입력하는 EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EditText 위젯을 findViewById를 사용하여 연결
        nameEditText = findViewById(R.id.name)
        menuEditText = findViewById(R.id.menu)
        numEditText = findViewById(R.id.num_people)

    }

    // 버튼 클릭 이벤트 핸들러 메서드
    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.button -> {
                val nameText = nameEditText.text.toString()
                val titleText = menuEditText.text.toString()

                // UserData 객체를 생성하여 데이터 저장
                val userData = UserData(nameText, titleText)

                // 가져온 데이터를 사용
                val message = "이름: ${userData.name}, 메뉴: ${userData.menu}"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                // 새로운 액티비티로 전환
                val intent = Intent(this, Content::class.java)
                startActivity(intent)
            }
        }
    }
}
