package com.poriyanasri.project003quizofporiya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ProgressBar
import com.poriyanasri.project003quizofporiya.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val QuestionList = Constant.GetQuestion()
        val currentQuestion = 0
        val question = QuestionList[currentQuestion]
        binding.textViewTitle.text = question.Question
        binding.imageViewFlag.setImageResource(question.image)
        binding.textViewQuestion1.text = question.optionOne
        binding.textViewQuestion2.text = question.optionTwo
        binding.textViewQuestion3.text = question.optionThree
        binding.textViewQuestion4.text = question.optionFour
        binding.textViewProcess.text ="${currentQuestion+1} / ${binding.progressBar.max}"
    }
}