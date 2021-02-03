package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    val NUM_SIDES = 6
    //lateinit is a workaround to let the program know that while this variable has not been initialized, when we first run, still run because we garauntee that it will be leagally initialized
    lateinit var DICE_IMAGE: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // this is an object that is linked to the button in the xml file, by the id we created
        val rollButton: Button = findViewById(R.id.roll_button)
        //can also write as val rollButton = findViewBy<Button>(R.id.roll_button)
        rollButton.text = getString(R.string.roll_button_text)
        // a toast is a little pop up text block that let's you know that an action has been performed
        // ie, url copied, message sent
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT)
//            toast.show()
            // shorthand: Toast.makeText(this, text: "button clicked", Toast.LENGTH_SHORT).show()
            // all of the above code is more of a checkpoint to see that the program is working at this point
            // (kinda like a print statement showing when you click on a button to verify that the button action listener works)
            rollDice()
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
}