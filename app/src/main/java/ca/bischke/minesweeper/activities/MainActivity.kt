package ca.bischke.minesweeper.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ca.bischke.minesweeper.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonStart(view: View) {
        val intent = Intent(this@MainActivity, GameActivity::class.java)
        intent.putExtra("Width", 10)
        intent.putExtra("Height", 10)
        startActivity(intent)
    }
}
