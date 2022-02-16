package com.devankav.tictactoe

private const val TAG = "Board"

class Board {
    private val board = arrayOf(
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY)
    )
    private var currentSymbol: Tile = Tile.X

    private fun tileOpen(row: Int, column: Int) = board[row][column] == Tile.EMPTY

    fun gameOver(): Boolean {
        // TODO: Implement game over state
        return false
    }

    fun getCurrentSymbol() = currentSymbol

    private fun toggleSymbol() {
        currentSymbol = if (currentSymbol == Tile.X) Tile.O else Tile.X
    }

    fun takeTile(row: Int, column: Int) {
        if (tileOpen(row, column)) {
            board[row][column] = currentSymbol
            toggleSymbol()
        }
    }

    fun resetBoard() {
        for (row: Array<Tile> in board) {
            for (i in 0..2) {
                row[i] = Tile.EMPTY
            }
        }

        currentSymbol = Tile.X
    }

    fun getSymbol(row: Int, column: Int) = board[row][column]
}