package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    var numSides = 6
    lateinit var DICE_IMAGE: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = getString(R.string.roll_button_text)
        rollButton.setOnClickListener {
            rollDice()
        }

        val decreaseButton: Button = findViewById(R.id.decrease_button)
        decreaseButton.text = getString(R.string.decrease_maximum_value, numSides - 1)
        decreaseButton.setOnClickListener{
            decreaseMaxValue()
            if (numSides == 1){
                decreaseButton.visibility = View.INVISIBLE
            } else {
                decreaseButton.text = getString(R.string.decrease_maximum_value, numSides - 1)
            }
        }

        DICE_IMAGE = findViewById<ImageView>(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(numSides) + 1
        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        DICE_IMAGE.setImageResource(drawableResource)
    }

    private fun decreaseMaxValue() {
        numSides = if (numSides == 1) 1 else numSides - 1
    }
}