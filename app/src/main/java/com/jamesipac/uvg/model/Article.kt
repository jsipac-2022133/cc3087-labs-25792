package com.jamesipac.uvg.model

import androidx.compose.ui.graphics.Color

data class Article(
    val author: String,
    val title: String,
    val content: String,
    val readingMinutes: Int,
    val date: String,
    val avatarColor: Color,
    val thumbnailColor: Color
)