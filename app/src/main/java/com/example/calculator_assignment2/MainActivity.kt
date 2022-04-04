package com.example.assignmentn2_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextClock
import android.widget.TextView
import com.example.calculator_assignment2.R

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand: Double=0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView=findViewById(R.id.resultTextView)
    }



    fun numberClick (clickedview: View)
    {
        if(clickedview is TextView)
        {
            var result = resultTextView.text.toString()
            val number = clickedview.text.toString()

            if (result == "0")
            {
                result = ""
            }

            resultTextView.text = result + number
        }
    }



    fun operationClick (clickedview: View)
    {
        if (clickedview is TextView)
        {
            var operand = resultTextView.text.toString()
            this.operand = operand.toDouble()
            operation = clickedview.text.toString()
            resultTextView.text = ""
        }
    }


    fun equalsClick (clickedview: View)
    {
        val secOperand = resultTextView.text.toString().toDouble()
        when(operation)
        {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }
    }

    fun clear (clickedview: View)
    {
        resultTextView.text = ""
    }

    fun delete (clickedview: View)
    {
        val length = resultTextView.length()
        if (length > 0)
            resultTextView.text = resultTextView.text.subSequence(0, length -1)
    }



    fun dot (clickedview: View)
    {
        resultTextView.text = resultTextView.text.toString() + "."
    }
}