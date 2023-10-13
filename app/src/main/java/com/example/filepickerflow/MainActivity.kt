package com.example.filepickerflow

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.example.filepickerflow.ui.theme.FilePickerFlowTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel:FilesViewModel by viewModels()
        setContent {
            val context  = LocalContext.current
            val demoSelect = rememberDemoName(onName = {} )


            val urii = viewModel.selectedFile.collectAsState()
            LaunchedEffect(key1 = urii.value){
                if(urii.value != Uri.EMPTY){
                    Toast.makeText(context,urii.value.toString(),Toast.LENGTH_SHORT).show()
                }
            }
            FilePickerFlowTheme {
                val selectFile = rememberFilePicker(onFile = {viewModel.setSelectedFile(it)})
                Button(onClick = { selectFile.pick("image/*") }) {
                    Text("pick")
                }

            }
        }
    }
}

