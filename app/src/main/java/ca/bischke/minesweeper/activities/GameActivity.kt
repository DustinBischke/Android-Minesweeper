package ca.bischke.minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.bischke.minesweeper.BoardModel
import ca.bischke.minesweeper.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val boardModel = BoardModel(10, 10, 10)
        board_view.createBoard(boardModel)
    }
}
