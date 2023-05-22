package com.example.mysmarthome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView


class Routines : Fragment() {
    private  var intent = Intent()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val rout = inflater.inflate(R.layout.fragment_routines, container, false)
        val sharedPrefs = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPrefs.getString("routineName1", "")
        val message = intent.getStringExtra("NOTIFICATIONS")
        if (message != "null") {
            val layerToBeWorkOn = rout.findViewById<ScrollView>(R.id.listOfRoutines)
            val layerToBeRemove = rout.findViewById<LinearLayout>(R.id.myRoutines)
            //changing the views in the the routines fragment
            //Changing the content of some layers
            val replacementView = layoutInflater.inflate(R.layout.routine_skeleton, null)
            layerToBeWorkOn.removeView(layerToBeRemove)
            layerToBeWorkOn.addView(replacementView)
            val editName = replacementView.findViewById<TextView>(R.id.routineName)
            editName.text = text
        }
//        val layerToBeWorkOn = rout.findViewById<ScrollView>(R.id.listOfRoutines)
//        val layerToBeRemove = rout.findViewById<LinearLayout>(R.id.myRoutines)
//        //changing the views in the the routines fragment
//        //Changing the content of some layers
//        val replacementView = layoutInflater.inflate(R.layout.routine_skeleton, null)
//        layerToBeWorkOn.removeView(layerToBeRemove)
//        layerToBeWorkOn.addView(replacementView)
//        val editName = replacementView.findViewById<TextView>(R.id.routineName)
//        editName.text = text

        return rout
    }

}