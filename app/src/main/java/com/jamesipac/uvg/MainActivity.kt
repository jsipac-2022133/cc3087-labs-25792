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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}