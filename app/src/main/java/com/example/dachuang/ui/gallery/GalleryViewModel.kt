package com.example.dachuang.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    var x = 1
        get() {
            field += 1
            return field
        }
    val text: LiveData<String>
        get() {
            this._text.value += "$x"
            return this._text
        }
}