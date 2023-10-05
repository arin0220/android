package com.example.rollingpaper
// 패키지 옮김

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.rollingpaper.R

class Content : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.content) // 새로운 액티비티의 레이아웃 파일을 설정
//    }
    private lateinit var nameEditText: EditText
    private lateinit var contentEditText: EditText
    private var clickCount = 0 // 초기 클릭 카운트 설정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        nameEditText = findViewById(R.id.name)
        contentEditText = findViewById(R.id.content)

        // 버튼3~6에 대한 클릭 리스너 설정
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            clickCount++
            handleButtonClick(clickCount)
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            clickCount++
            handleButtonClick(clickCount)
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            clickCount++
            handleButtonClick(clickCount)
        }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            clickCount++
            handleButtonClick(clickCount)
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
