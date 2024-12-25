package com.example.quizapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialize the question list
        list = ArrayList()
        list.add(QuestionModel("Who is the PM of India?", "Modi", "Keju", "Rahul", "Nitin", "Modi"))
        list.add(QuestionModel("What is the capital of India?", "Mumbai", "Delhi", "Chennai", "Kolkata", "Delhi"))
        list.add(QuestionModel("What is 2 + 2?", "3", "4", "5", "6", "4"))
        list.add(QuestionModel("Which planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter", "Mars"))
        list.add(QuestionModel("What is the national animal of India?", "Tiger", "Lion", "Elephant", "Peacock", "Tiger"))
        list.add(QuestionModel("Who discovered gravity?", "Newton", "Einstein", "Galileo", "Darwin", "Newton"))
        list.add(QuestionModel("What is the smallest prime number?", "0", "1", "2", "3", "2"))
        list.add(QuestionModel("What is the boiling point of water?", "50°C", "100°C", "200°C", "150°C", "100°C"))
        list.add(QuestionModel("Who wrote 'Romeo and Juliet'?", "Shakespeare", "Homer", "Chaucer", "Milton", "Shakespeare"))
        list.add(QuestionModel("Which is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Tiger", "Blue Whale"))

        // Initialize the first question
        loadQuestion()

        // Set click listeners for options
        binding.option1.setOnClickListener {
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextData(binding.option4.text.toString())
        }
    }

    // Load the current question and options
    private fun loadQuestion() {
        binding.question.text = list[count].question
        binding.option1.text = list[count].option1
        binding.option2.text = list[count].option2
        binding.option3.text = list[count].option3
        binding.option4.text = list[count].option4
    }

    // Handle the next question
    private fun nextData(selectedAnswer: String) {
        // Check if the selected answer is correct
        if (list[count].ans == selectedAnswer) {
            score++
        }

        count++

        // Check if the quiz is finished
        if (count >= list.size) {
            Toast.makeText(this, "Your Score: $score/${list.size}", Toast.LENGTH_LONG).show()
        } else {
            // Load the next question
            loadQuestion()
        }
    }
}
