package ca.bischke.minesweeper

class CellModel(val x: Int, val y: Int) {
    var isMine = false
    var neighborMines = 0
}