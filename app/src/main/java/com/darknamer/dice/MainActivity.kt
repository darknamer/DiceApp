package com.darknamer.dice

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDice1 = findViewById<TextView>(R.id.tvDice1)
        val tvDice2 = findViewById<TextView>(R.id.tvDice2)
        val tvState = findViewById<TextView>(R.id.tvState)
        val btnClickRandom = findViewById<Button>(R.id.btnClickRandom)

        btnClickRandom.setOnClickListener {
            btnClickRandom.isClickable = false
            tvState.text = "State: Application are random numbers."

            val dice1 = this.randomDice()
            Log.d("RND", "dice 1 -> $dice1")
            val animator1 = ValueAnimator.ofInt(0, dice1)
            animator1.duration = 1000
            animator1.addUpdateListener { animation -> tvDice1.text = animation.animatedValue.toString() }
            animator1.start()

            val dice2 = this.randomDice()
            Log.d("RND", "dice 2 -> $dice2")
            val animator2 = ValueAnimator.ofInt(0, dice2)
            animator2.duration = 1000
            animator2.addUpdateListener { animation -> tvDice2.text = animation.animatedValue.toString() }
            animator2.start()

            tvState.text = "State: Ready to Random."
            btnClickRandom.isClickable = true
        }
    }

    private fun randomDice(): Int {
        return (1..6).random()
    }
}