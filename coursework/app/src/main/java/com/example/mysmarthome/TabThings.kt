package com.example.mysmarthome


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class TabThings : Fragment() {
    private lateinit var myTextView: TextView
    private lateinit var myImage: ImageView
    private lateinit var myLayer: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab_things, container, false)
        // Get SharedPreferences instance
        //val sharedPrefs = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        // Find the views by their IDs
        myTextView = view.findViewById(R.id.changnottext)
        myImage = view.findViewById(R.id.myNotification)
        myLayer = view.findViewById(R.id.notLayer)


        myImage.setOnClickListener {
            // Check if myNotification is a child of notLayer
            if (myImage.parent == myLayer) {
                // Remove myNotification from notLayer
                myLayer.removeView(myImage)
            }
            myTextView.text = "Enter your notification text here..."
        }

        var intent: Intent
        val controlNot = "Open Notification Dialogue"
// Displaying the dialog on tapping a view
        myTextView.setOnClickListener {
            intent = Intent(activity, CreateRoutine::class.java)
            intent.putExtra("MY_KEY",controlNot)
            startActivity(intent)
        }

        return view
    }

}