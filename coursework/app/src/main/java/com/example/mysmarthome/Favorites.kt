package com.example.mysmarthome

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Favorites : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_favorites, container, false)
        val btn = v.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        btn.setOnClickListener {
            val intent = Intent(activity, RoutineSelection::class.java)
            startActivity(intent)
        }

        return v
    }



//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.favorites_menu, menu)
//    }


}