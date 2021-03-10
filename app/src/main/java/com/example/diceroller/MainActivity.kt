package com.example.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import java.util.*

const val KEY_MAX_VALUE = "max_dice_value"

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

        if (savedInstanceState != null) {
            numSides = savedInstanceState.getInt(KEY_MAX_VALUE)
            updateImage(numSides)
        }

        val decreaseButton: Button = findViewById(R.id.decrease_button)
        decreaseButton.text = getString(R.string.decrease_maximum_value, numSides - 1)
        decreaseButton.setOnClickListener {
            Timber.i("MAX VALUE DECREASED; NUM SIDES NOW $numSides")
            decreaseMaxValue()
            if (numSides == 1) {
                decreaseButton.visibility = View.INVISIBLE
            } else {
                decreaseButton.text = getString(R.string.decrease_maximum_value, numSides - 1)
            }
        }

        DICE_IMAGE = findViewById<ImageView>(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(numSides) + 1
        updateImage(randomInt)
    }

    private fun updateImage(dieValue: Int) {
        DICE_IMAGE.setImageResource(
                when (dieValue) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
        )
    }

    private fun decreaseMaxValue() {
        if (numSides != 1) numSides--
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("SAVING DATA; MAX DIE VALUE IS $numSides")
        outState.putInt(KEY_MAX_VALUE, numSides)
    }

    override fun onStart() {
        super.onStart()
        Timber.i("APP STARTED")
        Timber.i("RETRIEVING DATA; MAX DIE VALUE IS $numSides")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("APP RESUMED")
        Timber.i("RETRIEVING DATA; MAX DIE VALUE IS $numSides")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("APP PAUSED")
        Timber.i("SAVING DATA; MAX DIE VALUE IS $numSides")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("APP STOPPED")
        Timber.i("SAVING DATA; MAX DIE VALUE IS $numSides")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("APP DESTROYED")
        Timber.i("MAX DIE VALUE IS $numSides")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("APP RESTARTED")
        Timber.i("MAX DIE VALUE IS $numSides")
    }
}