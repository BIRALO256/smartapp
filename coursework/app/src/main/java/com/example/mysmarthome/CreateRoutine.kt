package com.example.mysmarthome

import android.animation.ObjectAnimator
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isEmpty
import com.example.mysmarthome.databinding.ActivityCreateRoutineBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


import java.sql.Timestamp
import java.util.*

class CreateRoutine : AppCompatActivity() {
    private lateinit var timePicker: TimePicker
    private lateinit var timeTextView: TextView
    private lateinit var settingIcon: ImageView
    private lateinit var textInputLayout: TextInputLayout
    private lateinit var textInputEditText: TextInputEditText
    private lateinit var binding: ActivityCreateRoutineBinding
    private lateinit var progressBar: ProgressBar
    private lateinit var dialogg: Dialog
    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("hh:mm a", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRoutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val message = intent.getStringExtra("TIME_KEY")
        val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
        val  notifDialog = intent.getStringExtra("MY_KEY")
        val replacementView = layoutInflater.inflate(R.layout.time_display, null)
        val myTime = replacementView.findViewById<TextView>(R.id.timeDisplay)


        //Action of adding an event
        binding.addEvent.setOnClickListener {
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
            if (hasWindowFocus()){
            }
        }
        //Action to be perform on clicking the add action action button
        binding.addAction.setOnClickListener {
            val intent = Intent(this,ThingSelection::class.java)
            startActivity(intent)
        }
        //function implementation of the canceling button
        binding.cancelingButton.setOnClickListener {
            val intent = Intent(this, RoutineSelection::class.java)
            startActivity(intent)
        }
        //function implementation of the saving button
        binding.savingButton.setOnClickListener {
            val routineName = textInputEditText.text.toString()
            //progress bar functionality.
            // Get SharedPreferences editor
            val editor = sharedPrefs.edit()
            // Save the text to SharedPreferences
            editor.putString("routineName1", routineName)
            editor.apply()

        }

        // Get references to UI elements
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.textInputEditText)

        // Customize the appearance of the text input field
        textInputLayout.boxStrokeColor = ContextCompat.getColor(this, R.color.black)
        textInputLayout.setHintTextAppearance(R.style.BoldHintTextAppearance)

        // Set focus listener on the text input field to show/hide the hint text
        textInputEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                textInputLayout.hint = null
                binding.myHintText.visibility = View.VISIBLE
            } else if (textInputEditText.text.isNullOrBlank()) {
                textInputLayout.hint = getString(R.string.r14)
            }
        }

        // Get references to UI elements
        timePicker = TimePicker(this)

        val savedTimeInMillis = sharedPrefs.getLong("selected_time", -1)
        if (savedTimeInMillis != -1L) {
            val savedTime = Calendar.getInstance()
            savedTime.timeInMillis = savedTimeInMillis
            val timeFormatter = SimpleDateFormat("hh:mm a", Locale.getDefault())
            myTime.setText(timeFormatter.format(savedTime.time))

        }


        //Time picker dialog
        // id int 5 is imp
        val int = 8

        val timePickerDialog =TimePickerDialog(
            this,
            int,
            object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    calendar.apply {
                        set(Calendar.HOUR_OF_DAY, hourOfDay)
                        set(Calendar.MINUTE, minute)
                        val selectedTime = Calendar.getInstance()
//                        val selectedTime = String.format("The time is %02d:%02d", hourOfDay, minute)
//                        val myTime = replacementView.findViewById<TextView>(R.id.timeDisplay)
//                        myTime.text = selectedTime
                        // Save the selected time in shared preferences
                        val editor = sharedPrefs.edit()
                        editor.putLong("selected_time", selectedTime.timeInMillis)
                        editor.apply()
                    }


                    displayFormatedTime(calendar.timeInMillis)

                }
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )

             /*
            { _, hourOfDay, minute ->
                // get the selected time as a formatted string
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)

                // set the text of the TextView to the selected time
                val myTime = replacementView.findViewById<TextView>(R.id.timeDisplay)
                myTime.text = selectedTime
            }, 12, 0, false)

             */



        if (message != null || notifDialog != null) {
            //Changing the content of some layers
            val replacementView = layoutInflater.inflate(R.layout.time_display, null)
            val myTime = replacementView.findViewById<TextView>(R.id.timeDisplay)
            binding.changingLayer1.removeView(binding.timeDisplayTextView)
            binding.changingLayer1.addView(replacementView)
            myTime.text = "The time is "+ currentTime
            binding.myEventConditionView.text = resources.getString(R.string.r15)
            binding.layerForConditions.visibility = View.VISIBLE
            if (notifDialog == null)
                timePickerDialog.show()
            }


        // Creating a dialog builder object
        val dialogBuilder = AlertDialog.Builder(this)

// Setting dialog title
        dialogBuilder.setTitle("Enter value")

// Creating text input field
        val input = EditText(this)
        dialogBuilder.setView(input)

// Adding buttons to the dialog
        dialogBuilder.setPositiveButton("Ok") { dialog, which ->
            //savingDia.show()
            // Saving the entered text to local storage
            val enteredText = input.text.toString()
            // Get SharedPreferences editor
            val editor = sharedPrefs.edit()
            // Save the text to SharedPreferences
            editor.putString("textNot", enteredText)
            editor.apply()
            //creating a dialog progress
            dialogg = Dialog(this)
            dialogg.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogg.setContentView(R.layout.progress_bar)
            val progressTextView = dialogg.findViewById<TextView>(R.id.progress_text_view)
            val progressBar = dialogg.findViewById<ProgressBar>(R.id.progress_bar)
            progressBar.max = 100
            progressBar.isIndeterminate = true // Set ProgressBar to indeterminate mode
            progressTextView.text = "Creating new Routine"
            val notTextv = findViewById<TextView>(R.id.notDisplay)
            val text = sharedPrefs.getString("textNot", "")
            notTextv.text = "Send Notification: " + text
            val toRoutine = "Open Routine Fragment"
            val moveToRoutineFrag = Intent(this, MainActivity::class.java)
            moveToRoutineFrag.putExtra("NOTIFICATIONS",toRoutine)

            val handler = Handler(Looper.getMainLooper())
            var progress = 0

            val updateRunnable = object : Runnable {
                override fun run() {
                    progress += 10
                    progressBar.progress = progress
                    progressTextView.text = "Creating new Routine"
                    if (progress < 100) {
                        handler.postDelayed(this, 1000) // Update progress every 1 seconds
                    } else {
                        notTextv.text = "Send Notification: " + text
                        dialogg.dismiss()
                        startActivity(moveToRoutineFrag)
                    }
                }
            }

            handler.postDelayed(updateRunnable, 10000) // Start updating progress after 10 seconds

            dialogg.show()

            //End of the code

            // Perform your database save operation here asynchronously
        }

        dialogBuilder.setNegativeButton("Cancel") { dialog, which ->
            // Closing the dialog on Cancel button click
            dialog.dismiss()
        }

         // Creating the dialog instance
        val dialog = dialogBuilder.create()


        if (notifDialog != null){
            //Changing the content of some layers
            val replacementNotView = layoutInflater.inflate(R.layout.notification_layer, null)
            binding.changingLayer2.removeView(binding.actionTextView)
            binding.changingLayer2.addView(replacementNotView)
            dialog.show()
        }



        //Autoclicking the setting icon
//        settingIcon.post {
//            //Making the layer for adding condition visible
//            if (message != null) {
//                binding.layerForConditions.visibility = View.VISIBLE
//                settingIcon.performClick()
//            }
//
//        }
//
//        // Set click listener on the setting icon to show the time picker dialog
//
//        settingIcon.setOnClickListener {
//        }

    }

//    override fun onResume() {
//        super.onResume()
//
//        // Set initial hint text
//        textInputLayout.hint = getString(R.string.r14)
//    }

    private fun displayFormatedTime(timestamp: Long){
        //trying to bold the characters from index 12 to 20 exclusive
        val event1 = SpannableStringBuilder("The time is " + formatter.format(timestamp))

        event1.setSpan(
            StyleSpan(Typeface.BOLD),
            12, // start index of the span
            20, // end index of the span (exclusive)
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        Log.i("Formatting", timestamp.toString())

    }

}