package com.jamesipac.uvg.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jamesipac.uvg.data.articles
import com.jamesipac.uvg.model.Article
import com.jamesipac.uvg.ui.components.ArticleItem
import com.jamesipac.uvg.ui.components.Separator
import com.jamesipac.uvg.ui.components.TabsRow
import com.jamesipac.uvg.ui.components.TopBar
import com.jamesipac.uvg.ui.theme.FeedArticulosTheme

@Composable
fun FeedScreen(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TopBar()
        TabsRow()
        Separator()

        articles.forEach { articleFor ->
            ArticleItem(
                article = articleFor
            )
            Separator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedArticulosTheme {
        FeedScreen(
            articles = articles
        )
    }
}