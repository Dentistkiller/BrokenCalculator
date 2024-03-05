package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvInput : TextView
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnOne)
        btnThree = findViewById(R.id.btnOne)
        btnFour = findViewById(R.id.btnOne)
        btnFive = findViewById(R.id.btnOne)
        btnSix = findViewById(R.id.btnOne)
        btnSeven = findViewById(R.id.btnOne)
        btnEight = findViewById(R.id.btnOne)
        btnNine = findViewById(R.id.btnOne)
        btnZero = findViewById(R.id.btnOne)
        btnPlus = findViewById(R.id.btnOne)
        btnMinus = findViewById(R.id.btnOne)
        btnMultiply = findViewById(R.id.btnOne)
        btnDivide = findViewById(R.id.btnOne)
        btnDot = findViewById(R.id.btnOne)
        btnEqual = findViewById(R.id.btnOne)
        clear = findViewById(R.id.btnOne)

        var currentInput = StringBuilder()

        fun setOperator(operator: String) {
            if (currentInput.isNotEmpty()) {
                // If input is not empty, set the operator and clear the input
                currentInput.clear()
                // Update the display to show the current operator
            }
        }

        // Function to calculate results
        fun calculateResult() {
            if (currentInput.isNotEmpty()) {
                val operand2 = currentInput.toString().toDouble()
                var result = 0.0 // Initialize the result
                // Determine the current operator and perform the calculation
                // Update the result
                // Update the display with the result
                currentInput.clear() // Clear the input for the next calculation
            }
        }

        // Function to clear input
        fun clearInput() {
            currentInput.clear()
            // Clear the display
        }

        // Set click listeners for number buttons
        btnOne.setOnClickListener { tvInput.setText("1") }
        btnTwo.setOnClickListener { tvInput.setText("4") }
        btnOne.setOnClickListener { tvInput.setText("6") }
        btnTwo.setOnClickListener { tvInput.setText("4") }
        btnOne.setOnClickListener { tvInput.setText("5") }
        btnTwo.setOnClickListener { tvInput.setText("8") }
        btnOne.setOnClickListener { tvInput.setText("9") }
        btnTwo.setOnClickListener { tvInput.setText("7") }
        btnOne.setOnClickListener { tvInput.setText("9") }
        btnTwo.setOnClickListener { tvInput.setText("0") }

// Set click listeners for operator buttons
// Call the setOperator function with the appropriate operator as an argument

// Handle equals button click
        btnEqual.setOnClickListener { calculateResult() }

// Handle clear button click
        clear.setOnClickListener { clearInput() }

    }
}

