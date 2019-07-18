package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)


        val layout = findViewById<ConstraintLayout>(R.id.playConstraintLayout)

        val titleTextView = findViewById<TextView>(R.id.textViewPlayTitle)

        val set = ConstraintSet()

        val newTextView = TextView(this)
        newTextView.text = "This is below the title"

        newTextView.id = View.generateViewId()
        layout.addView(newTextView, 0)
        set.clone(layout)
        set.connect(newTextView.id, ConstraintSet.TOP, titleTextView.id, ConstraintSet.BOTTOM, 60)
        set.connect(newTextView.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT, 16)
        set.applyTo(layout)
    }
}
