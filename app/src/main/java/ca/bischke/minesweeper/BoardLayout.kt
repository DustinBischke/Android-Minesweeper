package ca.bischke.minesweeper

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.GridLayout

class BoardLayout(context: Context?, attrs: AttributeSet) : GridLayout(context, attrs) {
    fun createBoard(boardModel: BoardModel) {
        for (i in 0 until boardModel.width) {
            for (j in 0 until boardModel.height) {
                val params = LayoutParams(spec(i), spec(j))
                addView(createButton(boardModel, i, j), params)
            }
        }
    }

    private fun createButton(boardModel: BoardModel, x: Int, y: Int): Button {
        val button = Button(context)

        if (boardModel.cells[x][y].isMine) {
            button.text = "M"
        } else {
            button.text = boardModel.cells[x][y].neighborMines.toString()
        }

        return button
    }
}