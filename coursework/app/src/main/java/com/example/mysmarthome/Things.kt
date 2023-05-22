package com.example.mysmarthome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.mysmarthome.databinding.FragmentThingsBinding


class Things : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val thing = inflater.inflate(R.layout.fragment_things, container, false)




        return thing
    }


}