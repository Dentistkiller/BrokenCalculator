package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvFirstNumber: TextView
    private lateinit var tvOperator: TextView
    private lateinit var tvSecondNumber: TextView
    private lateinit var tvResult: TextView
    private lateinit var btnZero : Button
    private lateinit var btnOne : Button
    private lateinit var btnTwo : Button
    private lateinit var btnThree : Button
    private lateinit var btnFour : Button
    private lateinit var btnFive : Button
    private lateinit var btnSix : Button
    private lateinit var btnSeven : Button
    private lateinit var btnEight : Button
    private lateinit var btnNine : Button
    private lateinit var btnPlus : Button
    private lateinit var btnMinus : Button
    private lateinit var btnMultiply : Button
    private lateinit var btnDivide : Button
    private lateinit var btnDot : Button
    private lateinit var btnEqual : Button
    private lateinit var clear : Button
    var currentInput = StringBuilder()
    // Variables to hold the operands and type of calculation
    private var operand1: Double? = null
    private var operand2: Double? = null
    private var pendingOperation = "="

    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvFirstNumber = findViewById(R.id.tvFirstNumber)
        tvOperator = findViewById(R.id.tvOperator)
        tvSecondNumber = findViewById(R.id.tvSecondNumber)
        tvResult = findViewById(R.id.tvResult)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnZero = findViewById(R.id.btnZero)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnDot = findViewById(R.id.btnDot)
        btnEqual = findViewById(R.id.btnEqual)
        clear = findViewById(R.id.clear)

        setupButtons()
        setupEqualButton()
    }
    private fun setupButtons() {
        val numberButtons = listOf(
            R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree,
            R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven,
            R.id.btnEight, R.id.btnNine
        )

        val operationButtons = listOf(R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide)

        numberButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { v ->
                var checker = tvOperator.text.toString()
                if (checker == "") {
                    val button = v as Button
                    tvFirstNumber.append(button.text)
                }
                else{
                    val button = v as Button
                    tvSecondNumber.append(button.text)
                }
            }
        }

        operationButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { v ->
                operator = (v as Button).text.toString()
                tvOperator.text = operator
            }
        }

        clear.setOnClickListener {
            operand1 = null
            //operand2 = null
            tvFirstNumber.text = ""
            tvSecondNumber.text = ""
            tvOperator.text = ""
            tvResult.text = ""
            pendingOperation = "="
        }
    }

    private fun setupEqualButton() {
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val firstNumber = tvFirstNumber.text.toString().toDoubleOrNull()
            val secondNumber = tvSecondNumber.text.toString().toDoubleOrNull()

            if (firstNumber != null && secondNumber != null && operator != null) {
                val result = when (operator) {
                    "+" -> firstNumber + secondNumber
                    "-" -> firstNumber - secondNumber
                    "*" -> firstNumber * secondNumber
                    "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.NaN
                    else -> Double.NaN
                }

                tvResult.text = result.toString()
                // Clear the previous TextViews
                tvFirstNumber.text = ""
                tvOperator.text = ""
                tvSecondNumber.text = ""
            }
        }
    }
}