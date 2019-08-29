package ca.bischke.minesweeper

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class BoardModel(val width: Int, val height: Int, val numOfMines: Int) : ViewModel() {
    var cells: MutableList<MutableList<CellModel>> = mutableListOf()

    init {
        for (i in 0 until width) {
            val column: MutableList<CellModel> = mutableListOf()

            for (j in 0 until height) {
                column.add(CellModel(i, j))
            }

            cells.add(column)
        }

        placeMines()
        setCellNeighborMines()
    }

    private fun placeMines()
    {
        for (i in 0 until numOfMines) {
            var valid = false

            while (!valid) {
                val x = Random.nextInt(0, width)
                val y = Random.nextInt(0, height)

                if (!cells[x][y].isMine) {
                    cells[x][y].isMine = true
                    valid = true
                }
            }
        }
    }

    private fun getCellNeighbors(cellModel: CellModel) : MutableList<CellModel> {
        val neighbors = mutableListOf<CellModel>()
        val x = cellModel.x
        val y = cellModel.y

        // Above
        if (y > 0) {
            neighbors.add(cells[x][y - 1])
        }

        // Below
        if (y < height - 1) {
            neighbors.add(cells[x][y + 1])
        }

        // Left
        if (x > 0) {
            neighbors.add(cells[x - 1][y])

            if (y > 0) {
                neighbors.add(cells[x - 1][y - 1])
            }

            if (y < height - 1) {
                neighbors.add(cells[x - 1][y + 1])
            }
        }

        // Right
        if (x < width - 1) {
            neighbors.add(cells[x + 1][y])

            if (y > 0) {
                neighbors.add(cells[x + 1][y - 1])
            }

            if (y < height - 1) {
                neighbors.add(cells[x + 1][y + 1])
            }
        }

        return neighbors
    }

    private fun setCellNeighborMines() {
        for (i in 0 until width) {
            for (j in 0 until height) {
                var mines = 0

                getCellNeighbors(cells[i][j]).forEach {
                    if (it.isMine) {
                        mines += 1
                    }
                }

                cells[i][j].neighborMines = mines
            }
        }
    }

}