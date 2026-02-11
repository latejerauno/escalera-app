package com.grimoire.divisionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(32, 32, 32, 32)

        val inputA = EditText(this)
        inputA.hint = "Número A"
        inputA.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        layout.addView(inputA)

        val inputB = EditText(this)
        inputB.hint = "Número B"
        inputB.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        layout.addView(inputB)

        val button = Button(this)
        button.text = "Calcular"
        layout.addView(button)

        val resultsLayout = LinearLayout(this)
        resultsLayout.orientation = LinearLayout.VERTICAL
        layout.addView(resultsLayout)

        val df = DecimalFormat("0.0")

        button.setOnClickListener {
            resultsLayout.removeAllViews()

            val a = inputA.text.toString().toIntOrNull()
            val b = inputB.text.toString().toIntOrNull()

            if (a == null || b == null || a <= 0 || b <= 0) {
                Toast.makeText(this, "Solo números enteros positivos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val r = a.toDouble() / b.toDouble()

            for (i in 1..b) {
                val tv = TextView(this)
                tv.text = df.format(r * i)
                resultsLayout.addView(tv)
            }
        }

        setContentView(layout)
    }
}
