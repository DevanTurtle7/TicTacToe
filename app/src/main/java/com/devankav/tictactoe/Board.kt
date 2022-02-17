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

    fun getGameState(): GameState {
        // TODO: Implement game over state

        var emptySpaceFound: Boolean = false

        // Check horiz
        for (i in 0..2) {
            val row = board[i]

            if (Tile.EMPTY !in row) {
                if ((Tile.X in row) && (Tile.O !in row)) {
                    return GameState.WINNER_X
                } else if ((Tile.X !in row) && (Tile.O in row)) {
                    return GameState.WINNER_O
                }
            } else {
                emptySpaceFound = true
            }

            // TODO: Can do diagnal by doing row[i][i] and vertical by adding another for loop
        }

        return if (emptySpaceFound) {
            if (currentSymbol == Tile.X) {
                GameState.X_TURN
            } else {
                GameState.O_TURN
            }
        } else {
            GameState.WINNER_TIE
        }
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