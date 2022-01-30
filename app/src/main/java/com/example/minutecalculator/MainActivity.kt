package com.example.minutecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnPicker: Button = findViewById(R.id.btnDatePicker)


        btnPicker.setOnClickListener {
            Toast.makeText(this, "Presionado" , Toast.LENGTH_LONG ).show();

        }




    }

    fun clickedDatePicker(){

        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR);
        val month = myCalendar.get(Calendar.MONTH);
        val day  = myCalendar.get(Calendar.DAY_OF_MONTH)






        //DatePickerDialog();
        Toast.makeText(this, "Presionado" , Toast.LENGTH_LONG ).show();

    }

}