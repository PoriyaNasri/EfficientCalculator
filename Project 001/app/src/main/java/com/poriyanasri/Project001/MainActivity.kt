
package com.poriyanasri.Project001

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewSelectedDate =findViewById<TextView>(R.id.textViewSelectedDate)
        val textViewAgeInMinutes =findViewById<TextView>(R.id.textViewAgeInMinutes)
        val buttonChooseBirthday = findViewById<Button>(R.id.buttonChooseBirthday)
        buttonChooseBirthday.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDateInString = "$dayOfMonth/${month+1}/$year"
                    textViewSelectedDate.setText("${month+1}/$dayOfMonth/$year")
                    val simpleDateformatter =SimpleDateFormat("dd/mm/yyyy")
                    val selectedDate =simpleDateformatter.parse(selectedDateInString)
                    val selectedDateInMinutes =(selectedDate.time)/60000
                    val currentDate =simpleDateformatter.parse(simpleDateformatter.format(System.currentTimeMillis()))
                    val currentDateInMinutes =currentDate.time/60000
                    val AgeInMinutes =currentDateInMinutes-selectedDateInMinutes
                    textViewAgeInMinutes.setText(AgeInMinutes.toString())
                }, year, month, day)
            datePicker.show()
            datePicker.datePicker.maxDate=Date().time
        }
    }
}
