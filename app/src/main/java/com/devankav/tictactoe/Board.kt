package com.devankav.tictactoe

class Board {
    private val board = arrayOf(
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY)
    )

    private fun tileOpen(row: Int, column: Int) = board[row][column] == Tile.EMPTY

    fun takeTile(row: Int, column: Int, tileSymbol: Tile) {
        if (tileOpen(row, column)) {
            board[row][column] = tileSymbol
        }
    }

    fun clearTable() {
        for (row: Array<Tile> in board) {
            for (i in 0..2) {
                row[i] = Tile.EMPTY
            }
        }
    }
}