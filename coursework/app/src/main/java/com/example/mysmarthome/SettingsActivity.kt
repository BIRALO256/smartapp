package com.example.mysmarthome

/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.content.ContextCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set up theme spinner
        val themes = arrayOf("Light", "Dark", "Device default")
        val themeAdapter = ThemeAdapter(this, themes)
        theme_spinner.adapter = themeAdapter
        theme_spinner.setSelection(themeAdapter.getPosition(getThemePref()))
        theme_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> setThemePref("Light")
                    1 -> setThemePref("Dark")
                    2 -> setThemePref("Device default")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        // Set up font spinner
        val fonts = arrayOf("Default", "Sans-serif", "Serif", "Monospace")
        val fontAdapter = FontAdapter(this, fonts)
        font_spinner.adapter = fontAdapter
        font_spinner.setSelection(fontAdapter.getPosition(getFontPref()))
        font_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                setFontPref(fonts[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set up text color preference
        text_color_preference.color = getColorPref()
        text_color_preference.setOnPreferenceChangeListener { _, newValue ->
            val color = Color.parseColor(newValue.toString())
            setColorPref(color)
            true
        }

        // Set up log in button
        if (isLoggedIn()) {
            login_button.text = getString(R.string.logged_in_label)
            login_button.isEnabled = false
        } else {
            login_button.setOnClickListener {
                // Navigate to login activity
            }
        }

        // Set up create account button
        create_account_button.setOnClickListener {
            // Navigate to create account activity
        }

        // Set up save button
        save_button.setOnClickListener {
            // Save settings
            finish()
        }
    }

    private fun getThemePref(): String {
        // Get the theme preference from SharedPreferences
        return "Light" // Default value
    }

    private fun setThemePref(theme: String) {
        // Save the theme preference to SharedPreferences
        when (theme) {
            "Light" -> {
                setTheme(R.style.LightTheme)
                window.statusBarColor =
                    ContextCompat.getColor(this, R.color.light_theme_colorPrimaryDark)
            }
            "Dark" -> {
                setTheme(R.style.DarkTheme)
                window.statusBarColor =
                    ContextCompat.getColor(this, R.color.dark_theme_colorPrimaryDark)
            }
            "Device default" -> {
                setTheme(R.style.AppTheme)
                window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
            }
        }
        recreate()
    }

    private fun getFontPref(): String {
        // Get the font preference from SharedPreferences
        return "Default" // Default value
    }

    private fun setFontPref(font: String) {
        // Save the font preference to SharedPreferences
        // Apply font to the appropriate views
    }

    private fun getColorPref(): Int {
        // Get the text color preference from SharedPreferences
        return ContextCompat.getColor(this, R.color.colorAccent) // Default value
    }

    private fun setColorPref(color: Int) {
        // Save the text color preference to SharedPreferences
        text_color_preference.color = color
    }

    private fun isLoggedIn(): Boolean {
        // Check if user is logged in
        return false // Default value
    }
}

*/