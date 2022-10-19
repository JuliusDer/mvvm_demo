package com.example.mvvmdemo.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.vielmodel.DemoViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: DemoViewModel by viewModels() //delegate keeps the viewModel if destroyed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val messageButton: Button = findViewById(R.id.messageButton)
        messageButton.setOnClickListener { onMessageButtonClick() }

        viewModel.message.observe(this, ::onMessageUpdated)
    }

    private fun onMessageButtonClick() {
        val messageInput: EditText = findViewById(R.id.messageInput)
        viewModel.submitMessage(messageInput.text.toString())
    }

    private fun onMessageUpdated(newMessage: String) {
        val messageView: TextView = findViewById(R.id.messageView)
        messageView.text = newMessage
    }
}