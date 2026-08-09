package com.jamesipac.uvg.model

data class Article(
    val author: String,
    val title: String,
    val content: String,
    val readingMinutes: Int,
    val date: String
)