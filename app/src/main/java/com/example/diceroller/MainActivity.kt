package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import timber.log.Timber
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
            Timber.i("Die rolled")
        }


        val decreaseButton: Button = findViewById(R.id.decrease_button)
        decreaseButton.text = getString(R.string.decrease_maximum_value, numSides - 1)
        decreaseButton.setOnClickListener {
            Timber.i("MAX VALUE DECREASED; NUM SIDES NOW $numSides")
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

    private fun retrieveImage(dieValue :Int) {
        val drawableResource = when(dieValue) {
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
    
    override fun onStart() {
        super.onStart()
        Timber.i("APP STARTED")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
        Timber.i("APP RESUMED")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
        Timber.i("APP PAUSED")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
        Timber.i("APP STOPPED")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
        Timber.i("APP DESTROYED")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart called")
        Timber.i("APP RESTARTED")
    }
}