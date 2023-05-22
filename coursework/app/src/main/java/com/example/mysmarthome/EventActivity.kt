package com.example.mysmarthome

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import com.example.mysmarthome.databinding.ActivityEventBinding
import java.util.*

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView = findViewById<TextView>(R.id.event1)
//Event text that will be display in the list of events page
        val event1 = SpannableStringBuilder("The time is Time")
        val event2 = SpannableStringBuilder("It's sunset at Location")
        val event3 = SpannableStringBuilder("It's sunrise at Location")
        val event4 = SpannableStringBuilder("It's 15 minutes before sunrise at Location")
        val event5 = SpannableStringBuilder("It's 15 minutes after sunrise at Location")
        val event6 = SpannableStringBuilder("It's 15 minutes before sunset at Location")
        val event7 = SpannableStringBuilder("It's 15 minutes after sunset at Location")

/*
        event1.setSpan(
            ForegroundColorSpan(Color.RED),
            4, // start index of the span
            7, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

 */
//Styling the different words in the event strings
        event1.setSpan(
            StyleSpan(Typeface.BOLD),
            12, // start index of the span
            16, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        event2.setSpan(
            StyleSpan(Typeface.BOLD),
            15, // start index of the span
            23, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event3.setSpan(
            StyleSpan(Typeface.BOLD),
            16, // start index of the span
            24, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event4.setSpan(
            StyleSpan(Typeface.BOLD),
            5, // start index of the span
            7, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event4.setSpan(
            StyleSpan(Typeface.BOLD),
            34, // start index of the span
            42, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event5.setSpan(
            StyleSpan(Typeface.BOLD),
            5, // start index of the span
            7, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event5.setSpan(
            StyleSpan(Typeface.BOLD),
            32, // start index of the span
            41, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event6.setSpan(
            StyleSpan(Typeface.BOLD),
            5, // start index of the span
            7, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event6.setSpan(
            StyleSpan(Typeface.BOLD),
            33, // start index of the span
            41, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event7.setSpan(
            StyleSpan(Typeface.BOLD),
            5, // start index of the span
            7, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        event7.setSpan(
            StyleSpan(Typeface.BOLD),
            32, // start index of the span
            40, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        //Accessing the text views by id and changing their content to have the edited strings
        binding.event1.text = event1
        binding.event2.text = event2
        binding.event3.text = event3
        binding.event4.text = event4
        binding.event5.text = event5
        binding.event6.text = event6
        binding.event7.text = event7

        //back button function implementation
        binding.backToPrevious.setOnClickListener {
            val intent = Intent(this,CreateRoutine::class.java)
            startActivity(intent)
        }


        val myCon = findViewById<LinearLayout>(R.id.layerForConditions)
        var intent: Intent
        val control = "Open TimePicker Dialogue"

        //Below are the implementations of the
        // events that execute when different event in the select event page is clicked
        binding.event1.setOnClickListener {
            intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        //myCon.visibility = View.VISIBLE
        binding.event2.setOnClickListener {
             intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        binding.event3.setOnClickListener {
            intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        binding.event4.setOnClickListener {
             intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        binding.event5.setOnClickListener {
             intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        binding.event6.setOnClickListener {
             intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }
        binding.event7.setOnClickListener {
             intent = Intent(this, CreateRoutine::class.java)
            intent.putExtra("TIME_KEY",control)
            startActivity(intent)
        }

    }

}