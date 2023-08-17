package com.poriyanasri.calculatorefficient

import android.util.Log
import java.util.Stack

class Expression(var infixExpression: MutableList<String>) {
    private var postfix: String = ""
    private fun infixToPostfix() {
        var result = ""
        val stack = Stack<String>()
        for (element in infixExpression) {
            if (element.all { it.isDigit() } || element.any { it == '.' }) {
                result += "$element "
            } else if (element == "(") {
                stack.push(element)
            } else if (element == ")") {
                while (stack.peek() != "(" && stack.isNotEmpty()) {
                    result += "${stack.pop()}"
                }
                if (stack.isNotEmpty())
                    stack.pop()
            } else {
                while (stack.isNotEmpty() && precedence(stack.peek()) >= precedence(element)) {
                    result += "${stack.pop()} "
                }
                stack.push(element)
            }
        }
        while (stack.isNotEmpty()) {
            result += "${stack.pop()} "
        }
        postfix = result
    }

    private fun precedence(operator: String): Int {
        return when (operator) {
            "×", "÷" -> 2
            "+", "-" -> 1
            else -> -1
        }
    }

    fun evaluateExpression(): Number {
        infixToPostfix()
        val stack = Stack<Double>()
        var i = 0
        while (i < postfix.length) {
            if (postfix[i] == ' ') {
                i++
                continue
            } else if (Character.isDigit(postfix[i])) {
                var number = ""
                while (Character.isDigit(postfix[i]) || postfix[i] == '.') {
                    number += postfix[i]
                    i++
                }
                stack.push(number.toDouble())
            } else {
                val x = stack.pop()
                val y = stack.pop()
                when (postfix[i]) {
                    '×' -> stack.push(y * x)
                    '÷' -> stack.push(y / x)
                    '+' -> stack.push(y + x)
                    '-' -> stack.push(y - x)
                }
            }
            i++
        }
        return if (stack.peek() / stack.peek() == 1.0) stack.peek().toInt() else stack.peek()
    }
}