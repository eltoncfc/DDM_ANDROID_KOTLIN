package com.Hair2u.Hair2uApp.ui.galeria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Serviços"
    }
    val text: LiveData<String> = _text
}