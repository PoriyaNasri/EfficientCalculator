package com.poriyanasri.project003quizofporiya

data class Question(
    val id: Int,
    val Question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)