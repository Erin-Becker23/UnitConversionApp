
package com.example.unitconversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.DecimalFormat

class Result : AppCompatActivity() {

    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resul)

        result = findViewById(R.id.final_result)

        val finalnum = intent.getDoubleExtra("EXTRA_NUM", 0.0)
        val choice = intent.getStringExtra("EXTRA_CHOICE")
        val hundreth = DecimalFormat("##.##")

        val finalNumFormatted = hundreth.format(finalnum)

      var text = "You have converted from $choice and got $$finalNumFormatted"
        result.text = text



    }
}