package com.example.rollingpaper
// 패키지 옮김

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.content) // 새로운 액티비티의 레이아웃 파일을 설정
//    }
    private lateinit var nameEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        // 이전 액티비티(MainActivity)로부터 전달된 데이터를 받아옴
        val nameText = intent.getStringExtra("nameText")

        name = nameText.toString()
        // 타이틀바에 titleText 설정뮤
        title = nameText + "에게 축하 메시지 쓰기"

        nameEditText = findViewById(R.id.name)
        contentEditText = findViewById(R.id.content)

        val finish_button = findViewById<Button>(R.id.finish_button)
        finish_button.setOnClickListener {
            // SharedPreferences 초기화
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val nameText = nameEditText.text.toString()
            val contentText = contentEditText.text.toString()

            // 값을 SharedPreferences에 저장
            editor.putString("nameText", nameText)
            editor.putString("contentText", contentText)

            // 변경사항 저장
            editor.apply()

            // 새로운 화면으로 이동하기 위한 Intent 생성
            val intent = Intent(this, recyclerView_content::class.java)

            // Intent를 사용하여 다음 화면으로 이동
            startActivity(intent)
        }

    }

    fun onButton7Click(view: View) {
        val nameText = nameEditText.text.toString()
        val contentText = contentEditText.text.toString()

        // nameText와 contentText를 처리하거나 표시하는 로직을 여기에 추가합니다.
    }

    private fun handleButtonClick(clickCount: Int) {
        // 클릭된 버튼에 대한 작업을 수행합니다.
        // clickCount를 사용하여 버튼을 구분하거나 다른 작업을 수행합니다.
    }
}
