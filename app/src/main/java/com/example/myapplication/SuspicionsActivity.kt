package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class SuspicionsActivity : AppCompatActivity() {

    val TAG = "SuspicionsActivity"

    val people =
        arrayOf("Irene Adler", "Sherlock Holmes", "Mycroft Holmes", "Mrs Hudson", "Inspector Lastrade", "John Watson")
    val weapons = arrayOf("Lead Piping", "Dagger", "Candlestick", "Rope", "Revolver", "Wrench")
    val locations = arrayOf(
        "Baskerville",
        "Mrs Hudson's Kitchen",
        "Swimming Pool",
        "Tower of London",
        "The Lab",
        "221b Baker Street",
        "Irene's flat",
        "Dartmoor"
    )


    fun addNewTextViewUnderThisOne(
        layout: ConstraintLayout,
        aboveTextView: TextView,
        text: String,
        size: Float
    ): TextView {
        val set = ConstraintSet()
        val newTextView = TextView(this)
        newTextView.text = text
        newTextView.textSize = size
        newTextView.id = View.generateViewId()
        layout.addView(newTextView)
        set.clone(layout)
        set.connect(newTextView.id, ConstraintSet.TOP, aboveTextView.id, ConstraintSet.BOTTOM, 32)
        set.connect(newTextView.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT, 16)
        set.applyTo(layout)
        return newTextView
    }

    fun addTextGroup(layout: ConstraintLayout, lastTextView: TextView, title: String, items: Array<String>): TextView {
        var currentLast = addNewTextViewUnderThisOne(layout, lastTextView, title, 20f)
        for (item in items) {
            currentLast = addNewTextViewUnderThisOne(layout, currentLast, item, 14f)
        }
        return currentLast
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suspicions)

        var lastTextView = findViewById<TextView>(R.id.textViewTitle)

        val layout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        lastTextView = addTextGroup(layout, lastTextView, "People", people)
        lastTextView = addTextGroup(layout, lastTextView, "Weapons", weapons)
        lastTextView = addTextGroup(layout, lastTextView, "Locations", locations)

    }
}
