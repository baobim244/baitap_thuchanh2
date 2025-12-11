package com.example.bt_tuan2


import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val tvError = findViewById<TextView>(R.id.tvError)
        val listContainer = findViewById<LinearLayout>(R.id.listContainer)

        btnCreate.setOnClickListener {
            val inputStr = edtNumber.text.toString()

            // Reset giao diện
            tvError.text = ""
            listContainer.removeAllViews()

            val n = inputStr.toIntOrNull()

            if (n == null || n < 0) {
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"
            } else {
                for (i in 1..n) {

                    val btn = Button(this@MainActivity)
                    btn.text = i.toString()
                    btn.setTextColor(Color.WHITE)
                    btn.setBackgroundColor(Color.parseColor("#F44336"))

                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 10, 0, 0)
                    btn.layoutParams = params

                    listContainer.addView(btn)
                }
            }
        }
    }
}