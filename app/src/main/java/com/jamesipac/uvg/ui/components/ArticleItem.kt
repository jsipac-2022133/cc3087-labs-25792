package com.jamesipac.uvg.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamesipac.uvg.model.Article

@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(article.avatarColor)
                )

                Text(
                    text = article.author,
                    fontSize = 12.sp
                )
            }

            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )

            Text(
                text = article.content,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Row {
                Text(
                    text = "${article.readingMinutes} min de lectura · ${article.date}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(article.thumbnailColor)
        )
    }
}