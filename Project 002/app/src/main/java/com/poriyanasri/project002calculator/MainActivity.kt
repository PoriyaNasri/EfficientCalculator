package com.poriyanasri.project002calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.poriyanasri.project002calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var IsLastInputNumber = false
    var hasDotInTextView = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }

    fun OnDigitClick(view: View) {
        val ClickButton = view as Button
        binding.textView.append(ClickButton.text)
        IsLastInputNumber = true

    }

    fun ClearText(view: View) {
        binding.textView.text = " "
        IsLastInputNumber = false
        hasDotInTextView = false

    }

    fun OnDecimalPointClick(view: View) {
        if (IsLastInputNumber && !hasDotInTextView) {
            binding.textView.append(".")
            hasDotInTextView = true
        }
    }

    fun OnOperatorClick(view: View) {
        val button = view as Button
        if (IsLastInputNumber && !IsOperatorSelected(binding.textView.text.toString())) {
            binding.textView.append(button.text)
            IsLastInputNumber = false
            hasDotInTextView = false
        }
    }

    fun OnEqualClick(view: View) {
        var prefix = ""
        if (IsLastInputNumber) {
            var inputValue = binding.textView.text.toString()

            if (inputValue.startsWith("-")) {
                prefix = "-"
                inputValue = inputValue.substring(1)
            }
            if (inputValue.contains("+")) {
                val SplitValueArray = inputValue.split("+")
                var FirstNumber = SplitValueArray[0]
                val SecondNumber = SplitValueArray[1]
                val result = FirstNumber.toDouble() + SecondNumber.toDouble()
                binding.textView.text = result.toString()
            }
        }
        if (IsLastInputNumber) {
            val inputValue = binding.textView.text.toString()
            if (inputValue.contains("×")) {
                val SplitValueArray = inputValue.split("×")
                var FirstNumber = SplitValueArray[0]
                val SecondNumber = SplitValueArray[1]
                val result = FirstNumber.toDouble() * SecondNumber.toDouble()
                binding.textView.text = result.toString()
            }
        }
        if (IsLastInputNumber) {
            val inputValue = binding.textView.text.toString()
            if (inputValue.contains("÷")) {
                val SplitValueArray = inputValue.split("÷")
                var FirstNumber = SplitValueArray[0]
                val SecondNumber = SplitValueArray[1]
                val result = FirstNumber.toDouble() / SecondNumber.toDouble()
                binding.textView.text = result.toString()
            }
        }
        if (IsLastInputNumber) {
            val inputValue = binding.textView.text.toString()
            if (inputValue.contains("-")) {
                val SplitValueArray = inputValue.split("-")
                var FirstNumber = SplitValueArray[0]
                val SecondNumber = SplitValueArray[1]
                if (!prefix.isEmpty()) {
                    FirstNumber = prefix + FirstNumber
                }
                val result = FirstNumber.toDouble() - SecondNumber.toDouble()
                binding.textView.text = result.toString()
            }
        }
    }

    fun IsOperatorSelected(text: String): Boolean {
        if (text.startsWith("-")) {
            return false
        }
        if (text.contains("+") || text.contains("-") || text.contains("÷") ||
            text.contains("×") || text.contains("√") || text.contains("%")
        ) {
            return true
        } else {
            return false
        }
    }
}