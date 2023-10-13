package com.example.filepickerflow

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

public interface FilePicker {
    fun pick(mimetype:String = "/*")
}


@Composable
fun rememberFilePicker(onFile: (uri: Uri) -> Unit):FilePicker{
    val contract = remember{ ActivityResultContracts.GetContent()}
    val launcher = rememberLauncherForActivityResult(contract = contract, onResult = {
        if(it!=null){
            onFile(it)
        }
    })

    return remember {
        object : FilePicker{
            override fun pick(mimetype: String) {
                launcher.launch(mimetype)
            }
        }
    }
}