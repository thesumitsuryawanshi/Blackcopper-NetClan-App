package com.example.netclanapp.ui.Chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Contacts Fragment"
    }
    val text: LiveData<String> = _text
}