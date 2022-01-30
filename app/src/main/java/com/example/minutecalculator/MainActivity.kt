package com.example.minutecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private var tvDateSelected: TextView? = null
    private var tvMinutesCalculated: TextView? = null
    private var secretMsg: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPicker: Button = findViewById(R.id.btnDatePicker)


        tvDateSelected = findViewById(R.id.tvDateSelected)
        tvMinutesCalculated = findViewById(R.id.tvMinutesCalculated)
        secretMsg = findViewById(R.id.tvSecretMsg)

        btnPicker.setOnClickListener {

            clickedDatePicker()
        }


    }

    fun clickedDatePicker() {

        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR);
        val month = myCalendar.get(Calendar.MONTH);
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            { view, calYear, calMonth, calDay ->

                val formatedDate =
                    calDay.toString() + "/" + (calMonth + 1).toString() + "/" + calYear.toString();
                tvDateSelected?.text = formatedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val dateFormated = sdf.parse(formatedDate)
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val dateToMinutes = { myDate: Date? -> if (myDate != null) (myDate.time / 60000) else 0}

                val minutesCalculated = dateToMinutes(currentDate) - dateToMinutes(dateFormated)

                Log.d("MyApp",dateToMinutes(currentDate).toString() +" : " +  dateToMinutes(dateFormated).toString());

                tvMinutesCalculated?.text = minutesCalculated.toString()

                if (minutesCalculated < 0 ) secretMsg?.visibility = View.VISIBLE else secretMsg?.visibility = View.INVISIBLE


            },
            year,
            month,
            day
        ).show();


        //DatePickerDialog();

    }

}