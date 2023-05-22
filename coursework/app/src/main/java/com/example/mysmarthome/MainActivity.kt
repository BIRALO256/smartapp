package com.example.mysmarthome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mysmarthome.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val message = intent.getStringExtra("NOTIFICATIONS")
        if (message != null) {
            changeFragment(Routines())
        }
        else
            changeFragment(Favorites())


        //connecting to different fragments
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.favorite -> changeFragment(Favorites())
                R.id.things -> changeFragment(Things())
                R.id.routines -> changeFragment(Routines())
                R.id.ideas -> changeFragment(Ideas())
                R.id.settings -> changeFragment(Settings())

                else -> {

                }
            }
            true
        }

    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentController = supportFragmentManager
        val fragmentTransaction = fragmentController.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}