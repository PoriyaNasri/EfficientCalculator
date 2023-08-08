package com.poriyanasri.project003quizofporiya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.poriyanasri.project003quizofporiya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmitUserName.setOnClickListener {
            if (binding.EditTextUserName.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter Your Username ", Toast.LENGTH_LONG).show()
            } else{
                val intent=Intent(this ,QuestionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}