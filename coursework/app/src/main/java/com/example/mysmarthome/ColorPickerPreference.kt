package com.example.mysmarthome

/*
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.preference.PreferenceManager
import android.util.AttributeSet
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.listener.ColorListener
import com.github.dhaval2404.colorpicker.listener.DismissListener

class ColorPickerPreference(context: Context, attrs: AttributeSet) :
    androidx.preference.Preference(context, attrs) {

    private var color = Color.BLACK

    init {
        setOnPreferenceClickListener {
            ColorPickerDialog
                .Builder(context)
                .setColor(color)
                .setDialogTitle(R.string.text_color_title)
                .setPositiveButton(android.R.string.ok, ColorListener { color ->
                    this.color = color
                    persistString(Integer.toHexString(color).toUpperCase())
                })
                .setNegativeButton(android.R.string.cancel, null)
                .setDismissListener(DismissListener {
                    notifyChanged()
                })
                .show()
            true
        }
    }

    override fun onGetDefaultValue(a: TypedArray?, index: Int): Any {
        return a?.getString(index) ?: "c"
    }

    override fun onSetInitialValue(defaultValue: Any?) {
        color = try {
            Color.parseColor(defaultValue?.toString() ?: "")
        } catch (ex: IllegalArgumentException) {
            Color.BLACK
        }
        persistString(Integer.toHexString(color).toUpperCase())
    }

    override fun getSummary(): CharSequence {
        return Integer.toHexString(color).toUpperCase()
    }

    override fun persistString(value: String?): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString(key, value).commit()
    }

    override fun getPersistedString(defaultReturnValue: String?): String? {
        return PreferenceManager.getDefaultSharedPreferences(context)
            .getString(key, defaultReturnValue)
    }
}
*/


