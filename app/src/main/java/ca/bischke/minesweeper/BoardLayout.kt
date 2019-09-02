package ca.bischke.minesweeper

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import kotlinx.android.synthetic.main.layout_cell.view.*

class BoardLayout(context: Context?, attrs: AttributeSet) : GridLayout(context, attrs) {
    private var cellLayouts: MutableList<MutableList<CellLayout>> = mutableListOf()
    private lateinit var boardModel: BoardModel

    fun createBoard(boardModel: BoardModel) {
        this.boardModel = boardModel

        for (i in 0 until boardModel.width) {
            val column: MutableList<CellLayout> = mutableListOf()

            for (j in 0 until boardModel.height) {
                val cell = createCell(i, j)
                val params = LayoutParams(spec(i), spec(j))
                column.add(cell)
                addView(cell, params)
            }

            cellLayouts.add(column)
        }
    }

    private fun createCell(x: Int, y: Int): CellLayout {
        val cell = CellLayout(context)

        cell.button.apply {
            setOnClickListener {
                onClick(x, y)
            }
            setOnLongClickListener {
                true
            }
        }

        /*if (boardModel.cells[x][y].isMine) {
            cell.button.text = "M"
        } else {
            cell.button.text = boardModel.cells[x][y].neighborMines.toString()
        }*/

        return cell
    }

    private fun onClick(x: Int, y: Int) {
        cellLayouts[x][y].button.text = boardModel.cells[x][y].neighborMines.toString()
    }
}