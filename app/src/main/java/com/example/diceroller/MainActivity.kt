package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    var NUM_SIDES = 6
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
        decreaseButton.text = getString(R.string.decrease_maximum_value, NUM_SIDES-1)
        decreaseButton.setOnClickListener{
            decreaseMaxValue()
            if (NUM_SIDES == 1){
                decreaseButton.visibility = View.INVISIBLE
            } else {
                decreaseButton.text = getString(R.string.decrease_maximum_value, NUM_SIDES-1)
            }

            // having the toast here should confirm that the value has decrease; It does!
           Toast.makeText(this, "Max Value Decreased to $NUM_SIDES", Toast.LENGTH_SHORT).show()
        }

        DICE_IMAGE = findViewById<ImageView>(R.id.dice_image)
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(NUM_SIDES) + 1
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
        NUM_SIDES = if (NUM_SIDES == 1) 1 else NUM_SIDES-1
    }
}