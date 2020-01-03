package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var age = 0
    val datePicker = Calendar.getInstance()
    val selectedYear = datePicker.get(Calendar.YEAR)
    val selectedMonth = datePicker.get(Calendar.MONTH)
    val selectedDay = datePicker.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnReset: Button = findViewById(R.id.btnReset)
        btnReset.setOnClickListener { reset() }
        val btnCal: Button = findViewById(R.id.btnCal)
        btnCal.setOnClickListener { calculate() }
    }

    private fun calculate(){
        var bs = 0
        var total = 0.0
        if(editTotal.text.isEmpty()){
            total = 0.0
        }
        else{
            total = editTotal.text.toString().toDouble()
        }
        when{
            age>=16 && age<=20 -> {
                bs = 5000;txtBS.text = "Your Min. Basic Saving: RM5000"
            }
            age>=21 && age<=25 -> {
                bs = 14000;txtBS.text = "Your Min. Basic Saving: RM14,000"
            }
            age>=26 && age<=30 -> {
                bs = 29000;txtBS.text = "Your Min. Basic Saving: RM29,000"
            }
            age>=31 && age<=35 -> {
                bs = 50000;txtBS.text = "Your Min. Basic Saving: RM50,000"
            }
            age>=36 && age<=40 -> {
                bs = 78000;txtBS.text = "Your Min. Basic Saving: RM78,000"
            }
            age>=41 && age<=45 -> {
                bs = 116000;txtBS.text = "Your Min. Basic Saving: RM116,000"
            }
            age>=46 && age<=50 -> {
                bs = 165000;txtBS.text = "Your Min. Basic Saving: RM165,000"
            }
            age>=51 && age<=55 -> {
                bs = 228000;txtBS.text = "Your Min. Basic Saving: RM228,000"
            }
        }
        var withdraw = (total - bs)*0.3;if(withdraw<0.0){withdraw = 0.0}
        txtWithdraw.text = "Your max. withdrawable amount: RM" + withdraw
    }

    public fun datePicker(view: View){
        val picker  = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
            txtDate.text = "Your birthdate: " + "%d/%d/%d".format(dayOfMonth, month, year)
            age =  selectedYear - year
            txtAge.text = "Your age: " + age.toString()
        },selectedYear, selectedMonth, selectedDay)
        picker.show()
    }

    private fun reset(){
        editTotal.setText(null)
        txtDate.text = "Your birthdate: -"
        txtAge.text = "Your age: -"
        txtBS.text = "Your Min. Basic Saving: -"
        txtWithdraw.text = "Your max. withdrawable amount: -"
    }
}
