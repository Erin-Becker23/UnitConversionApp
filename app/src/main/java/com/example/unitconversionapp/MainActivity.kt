package com.example.unitconversionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var usd2peso: RadioButton
    lateinit var peso2usd: RadioButton
    lateinit var num2convert: EditText
    lateinit var convertButton: Button
    lateinit var resultText: TextView

    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton

    var convertChoice = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peso2usd = findViewById(R.id.radioButton2)
        usd2peso = findViewById(R.id.radioButton1)
        num2convert = findViewById(R.id.text_input)
        convertButton = findViewById(R.id.convert_button)
        resultText = findViewById(R.id.result_output)

        radioGroup = findViewById(R.id.RadioGroup)


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radioButton = findViewById(checkedId)
            if (checkedId == R.id.radioButton1) {
                Toast.makeText(
                    applicationContext,
                    "You selected: ${radioButton.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if (checkedId == R.id.radioButton2) {
                Toast.makeText(
                    applicationContext,
                    "You selected: ${radioButton.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }


            convertButton.setOnClickListener {
                val hundreth = DecimalFormat("##.##")
                val conversionRate = 19.4366 //peso per usd
                var convertedNumber: Double = 0.0

                //reading in the number from the user
                val num = num2convert.text.toString().toDouble()


                if (usd2peso.isChecked) {
                    convertChoice = radioButton.text.toString()
                    if (num <= 10000) {
                        convertedNumber = num * conversionRate
                        resultText.text = hundreth.format(convertedNumber) + "$ Pesos"
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "USD must be less than 10,000",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                if (peso2usd.isChecked) {
                    convertChoice = radioButton.text.toString()
                    if (num <= 10000) {
                        convertedNumber = num / conversionRate
                        resultText.text = hundreth.format(convertedNumber) + "$ USD"
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Pesos must be less than 10,000",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                }

                Intent(this@MainActivity, Result::class.java).also {
                    it.putExtra("EXTRA_NUM", convertedNumber)
                    it.putExtra("EXTRA_CHOICE", convertChoice )

                    startActivity(it)
            }


            }

        }
    }
}