package com.example.netclanapp.ui.Explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Expllore Fragment"
    }
    val text: LiveData<String> = _text
}