package com.example.galeritutorial.ui.first

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.example.galeritutorial.R
import com.example.galeritutorial.util.SharedPref
import java.util.*


class YearSelectionDialog : DialogFragment() {
/* Bu sınıfı Databinding oluşturmadan da kotlinde yapılabilirliğini göstermek istedim.*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private var yearpicker: NumberPicker? = null
    private var callback: YearSelectionCallback? = null

    interface YearSelectionCallback {
        fun onSelectYear(year: Int)
    }

    fun setCallback(callback: YearSelectionCallback?) {
        this.callback = callback
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_year_selection_dialog, null)
        yearpicker = view.findViewById(R.id.yearpicker)
        yearpicker?.minValue = Calendar.getInstance()[Calendar.YEAR].minus(10)
        yearpicker?.maxValue = Calendar.getInstance()[Calendar.YEAR].minus(5)
        yearpicker?.value = SharedPref.getInt(context!!, SharedPref.YEAR, 2016)
        builder.setView(view)
            .setTitle(getString(R.string.selectyear))
            .setCancelable(false)
            .setPositiveButton(R.string.ok,
                DialogInterface.OnClickListener { _, _ -> selectYear() })
        return builder.create()
    }

    private fun selectYear() {
        val year = yearpicker!!.value
        callback!!.onSelectYear(year)
        dismiss()
    }
}