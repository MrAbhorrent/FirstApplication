package ru.gb.kotlin.firstApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.util.Spliterators.iterator
import ru.gb.kotlin.firstApp.Weather as Weather

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

        val button1 = findViewById<Button>(R.id.btnNewText)
        val textView = findViewById<TextView>(R.id.tvWelcome)
        val button2 = findViewById<Button>(R.id.btnWeather)
        var button3 = findViewById<Button>(R.id.btnCopy)

        button1.setOnClickListener {
            if (textView.text.equals(tvTextRus)) {
                textView.text = tvTextEng
            } else {
                textView.text = tvTextRus
            }
            if (button1.text.equals(buttonTextRus)) {
                button1.text = buttonTextEng
            } else {
                button1.text = buttonTextRus
            }
        }

        button2.setOnClickListener {
            val weather = Weather("Омск", -4)
            Snackbar.make(this.findViewById(R.id.activity_main), "City : ${weather.town}, Temperature : ${weather.temperature}", Snackbar.LENGTH_SHORT).show()
        }

        button3.setOnClickListener {
            val DefaultCityWeather = Singleton.getMoskowWeather()
            val AnotherCopyWeather = DefaultCityWeather.copy()

            Snackbar.make(this.findViewById(R.id.activity_main), "Copy weather town : ${AnotherCopyWeather.town}, temp = ${AnotherCopyWeather.temperature}", Snackbar.LENGTH_SHORT).show()
        }
    }
}

object Singleton {
    private val MoskowWeather: Weather = Weather()

    fun  getMoskowWeather(): Weather {
        return Weather()
    }
}