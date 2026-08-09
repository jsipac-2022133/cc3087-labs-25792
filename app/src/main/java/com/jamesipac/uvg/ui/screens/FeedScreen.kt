/*
1. Al quitar el weight de la columna del artículo, el texto intenta ocupar más espacio
horizontal y la miniatura deja de tener bien reservado su espacio. Con weight, la columna
usa solamente el espacio sobrante y permite que la miniatura mantenga su tamaño.

2. ArticleItem recibe un Modifier para que la pantalla que lo utiliza pueda decidir su
espaciado. Así, si lo uso en dos pantallas con márgenes diferentes, puedo cambiar el
padding desde cada pantalla sin tener que modificar el componente.

Uso de IA:
Utilicé ia como apoyo para resolver dudas sobre Jetpack Compose, comprender
conceptos y revisar errores durante el desarrollo.
*/

package com.jamesipac.uvg.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        TopBar(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
        )

        TabsRow(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        )

        Separator()

        articles.forEach { articleFor ->
            ArticleItem(
                article = articleFor,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Separator(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
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