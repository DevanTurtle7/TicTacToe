package com.devankav.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"
private val board = Board()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resetGame()

        val resetButton: Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            resetGame()
        }

        val buttons = getButtons()
        buttons.forEach { button ->
            button.setOnClickListener { view ->
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

                button.text = tileSymbol.toString()
                updateGameStateLabel()
            }
        }
    }

    private fun getButtons(): List<Button> {
        return listOf(
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
    }

    private fun updateGameStateLabel() {
        val gameStateLabel: TextView = findViewById(R.id.gameStateLabel)

        val currentText: Int = if (board.gameOver()) {
            // TODO: Implement Winner/Tie text
            R.string.x_win
        } else {
            if (board.getCurrentSymbol() == Tile.X) {
                R.string.x_turn
            } else {
                R.string.o_turn
            }
        }

        gameStateLabel.setText(currentText)
    }

    private fun resetGame() {
        board.resetBoard()
        updateGameStateLabel()

        val buttons = getButtons()
        buttons.forEach{button ->
            button.text = ""
        }
    }
}