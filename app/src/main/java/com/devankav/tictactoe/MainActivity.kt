package com.devankav.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"
private val board = Board()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board.resetBoard()

        val buttons = listOf<Button>(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
        )

        buttons.forEach { button ->
            button.setOnClickListener(View.OnClickListener { view ->
                val row: Int
                val column: Int
                val name = view.tag.toString()

                row = when (name) {
                    "button1" -> 0
                    "button2" -> 0
                    "button3" -> 0
                    "button4" -> 1
                    "button5" -> 1
                    "button6" -> 1
                    "button7" -> 2
                    "button8" -> 2
                    "button9" -> 2
                    else -> 0
                }

                column = when (name) {
                    "button1" -> 0
                    "button2" -> 1
                    "button3" -> 2
                    "button4" -> 0
                    "button5" -> 1
                    "button6" -> 2
                    "button7" -> 0
                    "button8" -> 1
                    "button9" -> 2
                    else -> 0
                }

                board.takeTile(row, column)

                val tileSymbol = board.getSymbol(row, column)
                val button: Button = view as Button

                button.setText(tileSymbol.toString())
            })
        }
    }
}