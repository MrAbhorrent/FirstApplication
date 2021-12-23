package ru.gb.kotlin.firstApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Spliterators.iterator

class MainActivity : AppCompatActivity() {

    val buttonTextRus = "Жмякни"
    val buttonTextEng = "Push me"

    enum class buttonText {
        buttonTextEng,
        buttonTextRus
    }

    val tvTextRus = "Привет мир"
    val tvTextEng = "Hello World"

    enum class textViewText {
        tvTextEng,
        tvTextRus
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnNewText)
        val textView = findViewById<TextView>(R.id.tvWelcome)
        button.setOnClickListener {
            if (textView.text.equals(tvTextRus)) {
                textView.text = tvTextEng
            } else {
                textView.text = tvTextRus
            }
            if (button.text.equals(buttonTextRus)) {
                button.text = buttonTextEng
            } else {
                button.text = buttonTextRus
            }

        }
    }
}