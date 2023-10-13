package com.example.filepickerflow

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FilesViewModel(private val app: Application):AndroidViewModel(app) {
    private val _selectedFile = MutableStateFlow<Uri>(Uri.EMPTY)
    val selectedFile = _selectedFile.asStateFlow()


    fun setSelectedFile(uri:Uri){
        _selectedFile.value  = uri
    }
}