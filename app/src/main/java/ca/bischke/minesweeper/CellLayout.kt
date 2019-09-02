package ca.bischke.minesweeper

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout

class CellLayout(context: Context?) : LinearLayout(context) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_cell, this, true)
    }
}