package com.example.mvvmdemo.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.vielmodel.DemoViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: DemoViewModel by viewModels() //delegate keeps the viewModel if destroyed
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.messageButton.setOnClickListener { onMessageButtonClick() }

        viewModel.message.observe(this, ::onMessageUpdated)
    }

    private fun onMessageButtonClick() {
        viewModel.submitMessage(binding.messageInput.text.toString())
    }

    private fun onMessageUpdated(newMessage: String) {
        binding.messageView.text = newMessage
    }
}