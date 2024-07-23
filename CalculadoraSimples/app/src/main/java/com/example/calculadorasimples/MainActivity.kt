package com.example.calculadorasimples

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private var lastResult: Double? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calc = findViewById<TextView>(R.id.calc)
        val result = findViewById<TextView>(R.id.result)

        val buttonZero = findViewById<Button>(R.id.zero)
        buttonZero.setOnClickListener {
            calc.append("0")
        }

        val buttonOne = findViewById<Button>(R.id.one)
        buttonOne.setOnClickListener {
            calc.append("1")
        }

        val buttonTwo = findViewById<Button>(R.id.two)
        buttonTwo.setOnClickListener {
            calc.append("2")
        }

        val buttonThree = findViewById<Button>(R.id.three)
        buttonThree.setOnClickListener {
            calc.append("3")
        }

        val buttonFour = findViewById<Button>(R.id.four)
        buttonFour.setOnClickListener {
            calc.append("4")
        }

        val buttonFive = findViewById<Button>(R.id.five)
        buttonFive.setOnClickListener {
            calc.append("5")
        }

        val buttonSix = findViewById<Button>(R.id.six)
        buttonSix.setOnClickListener {
            calc.append("6")
        }

        val buttonSeven = findViewById<Button>(R.id.seven)
        buttonSeven.setOnClickListener {
            calc.append("7")
        }

        val buttonEight = findViewById<Button>(R.id.eight)
        buttonEight.setOnClickListener {
            calc.append("8")
        }

        val buttonNine = findViewById<Button>(R.id.nine)
        buttonNine.setOnClickListener {
            calc.append("9")
        }

        val buttonOpenParenthesis = findViewById<Button>(R.id.openParenthesis)
        buttonOpenParenthesis.setOnClickListener {
            calc.append("(")
        }

        val buttonCloseParenthesis = findViewById<Button>(R.id.closeParenthesis)
        buttonCloseParenthesis.setOnClickListener {
            calc.append(")")
        }

        val buttonDiv = findViewById<Button>(R.id.div)
        buttonDiv.setOnClickListener {
            calc.append("/")
        }

        val buttonMulti = findViewById<Button>(R.id.mult)
        buttonMulti.setOnClickListener {
            calc.append("*")
        }

        val buttonSub = findViewById<Button>(R.id.sub)
        buttonSub.setOnClickListener {
            calc.append("-")
        }

        val buttonSum = findViewById<Button>(R.id.sum)
        buttonSum.setOnClickListener {
            calc.append("+")
        }

        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener {
            calc.append(".")
        }

        val buttonErase = findViewById<Button>(R.id.erase)
        buttonErase.setOnClickListener {
            calc.text = calc.text.dropLast(1)
        }

        val buttonCE = findViewById<Button>(R.id.ce)
        buttonCE.setOnClickListener {
            calc.text = ""
        }

        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener {
            val expressionText = calc.text.toString()
            val modifiedExpressionText = if (expressionText.startsWith("+") || expressionText.startsWith("-") || expressionText.startsWith("*") || expressionText.startsWith("/")) {
                "$lastResult$expressionText"
            } else {
                expressionText
            }
            val calcResult = Expression(modifiedExpressionText).calculate()
            if (calcResult.isNaN()) {
                result.text = "Operação Inválida"
            } else {
                lastResult = calcResult
                result.text = calcResult.toString()
            }
        }
    }
}