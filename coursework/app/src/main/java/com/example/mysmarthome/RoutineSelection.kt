package com.example.mysmarthome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mysmarthome.databinding.ActivityRoutineSelectionBinding

class RoutineSelection : AppCompatActivity() {
    private lateinit var binding: ActivityRoutineSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoutineSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPrefs =getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPrefs.getString("routineName1", "")
        val additionalView = layoutInflater.inflate(R.layout.adding_routine, null)
        val horizontalDivider = layoutInflater.inflate(R.layout.horizontal_line, null)
        val newRoutineName = additionalView.findViewById<TextView>(R.id.additionalRoutineName)
        val listing = binding.listingRoutines
        val back = findViewById<ImageView>(R.id.backToMain)
        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.selectingRoutine.setOnClickListener {
            val intent = Intent(this, CreateRoutine::class.java)
            startActivity(intent)
        }
        if (text!!.isEmpty() != true){
            listing.addView(horizontalDivider)
            listing.addView(additionalView)
            newRoutineName.text = text
        }





    }

    fun go_back(view: View) {}
    fun create_routine(view: View) {}
}