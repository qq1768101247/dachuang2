package com.example.dachuang.ui.left.PersionInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersionInfoModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is PersionInfo"
    }
    val text: LiveData<String> = _text
}