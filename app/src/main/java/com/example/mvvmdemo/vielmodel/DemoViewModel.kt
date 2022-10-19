package com.example.mvvmdemo.vielmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.model.DemoModel

class DemoViewModel : ViewModel() {
    private val model = DemoModel("")

    private val _message = MutableLiveData(model.message)
    val message: LiveData<String> = _message

    fun submitMessage(message: String) {
        model.message = message
        _message.value = model.message
    }
}