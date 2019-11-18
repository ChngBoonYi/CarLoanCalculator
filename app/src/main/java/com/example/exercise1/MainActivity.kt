package com.example.exercise1

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val btn = findViewById<View>(R.id.buttonCalculate)

        btn.setOnClickListener(){

        }*/

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener(){
            calculateLoan(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener(){
            resetText(it)
        }
    }



   private fun calculateLoan(view:View){
       val price = editTextCarPrice.text.toString().toDouble()
       val downPayment = editTextDownPayment.text.toString().toDouble()
       val loanPeriod = editTextLoanPeriod.text.toString().toDouble()
       val intRate = editTextInterestRate.text.toString().toDouble()

       val loan = price - downPayment
       val interest:Double = loan * (intRate/100) * loanPeriod
       val monthlyRepay:Double = (loan + interest) / loanPeriod / 12

       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       imm.hideSoftInputFromWindow(view.windowToken, 0)

       textViewLoan.text = "Loan : %.2f".format(loan)
       textViewInterest.text = "Interest : %.2f".format(interest)
       textViewMonthlyRepayment.text="Monthly Repayment : %.2f".format(monthlyRepay)


   }

    private fun resetText(view: View){
        editTextCarPrice.getText().clear()
        editTextDownPayment.getText().clear()
        editTextLoanPeriod.getText().clear()
        editTextInterestRate.getText().clear()
        textViewLoan.setText("Loan : ")
        textViewInterest.setText("Interest : ")
        textViewMonthlyRepayment.setText("Monthly Repayment : ")

        editTextCarPrice.requestFocus()


    }




}
