package com.example.netclanapp.ui.Network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NetworkViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is Network Fragment"
    }
    val text: LiveData<String> = _text
}