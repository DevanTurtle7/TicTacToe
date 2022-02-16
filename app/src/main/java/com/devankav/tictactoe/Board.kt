package com.devankav.tictactoe

class Board {
    private val board = arrayOf(
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY),
        arrayOf(Tile.EMPTY, Tile.EMPTY, Tile.EMPTY)
    )

    fun tileOpen(row: Int, column: Int): Boolean {
        return false
    }

    fun takeTile(row: Int, column: Int) {
        
    }
}