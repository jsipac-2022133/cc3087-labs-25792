package com.jamesipac.uvg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jamesipac.uvg.data.articles
import com.jamesipac.uvg.ui.screens.FeedScreen
import com.jamesipac.uvg.ui.theme.FeedArticulosTheme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAB6_25792", "onCreate")
        enableEdgeToEdge()

        setContent {
            FeedArticulosTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    FeedScreen(
                        articles = articles,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("LAB6_25792", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("LAB6_25792", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("LAB6_25792", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("LAB6_25792", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("LAB6_25792", "onDestroy")
    }
}