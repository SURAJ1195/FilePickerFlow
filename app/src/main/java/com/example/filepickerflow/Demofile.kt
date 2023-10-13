package com.example.filepickerflow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

public interface DemoSelect {
fun select(name:String)
}

@Composable
fun rememberDemoName(onName : (name:String) -> Unit) : DemoSelect{
    return remember {
        object :DemoSelect{
            override fun select(name: String) {

            }

        }
    }
}