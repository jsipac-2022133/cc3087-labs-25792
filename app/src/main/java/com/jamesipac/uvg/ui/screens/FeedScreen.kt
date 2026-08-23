/*
1. Al quitar el weight de la columna del artículo, el texto intenta ocupar más espacio
horizontal y la miniatura deja de tener bien reservado su espacio. Con weight, la columna
usa solamente el espacio sobrante y permite que la miniatura mantenga su tamaño.

2. ArticleItem recibe un Modifier para que la pantalla que lo utiliza pueda decidir su
espaciado. Así, si lo uso en dos pantallas con márgenes diferentes, puedo cambiar el
padding desde cada pantalla sin tener que modificar el componente.

Uso de IA:
Utilicé IA como apoyo para resolver dudas sobre Jetpack Compose, comprender
conceptos y revisar errores durante el desarrollo.
*/

package com.jamesipac.uvg.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var applauseCount by rememberSaveable {
        mutableStateOf(0)
    }

    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    var showShortReadsOnly by rememberSaveable {
        mutableStateOf(false)
    }

    var selectedTab by rememberSaveable {
        mutableStateOf("Para ti")
    }

    val filteredArticles = articles.filter { article ->

        val matchesSearch =
            article.author.contains(searchQuery, ignoreCase = true) ||
                    article.title.contains(searchQuery, ignoreCase = true)

        val matchesDuration =
            !showShortReadsOnly || article.readingMinutes <= 5

        val matchesTab = when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }

        matchesSearch && matchesDuration && matchesTab
    }

    FeedContent(
        visibleArticles = filteredArticles,
        searchQuery = searchQuery,
        onSearchQueryChange = {
            searchQuery = it
        },
        showShortReadsOnly = showShortReadsOnly,
        onShortReadsOnlyChange = {
            showShortReadsOnly = it
        },
        selectedTab = selectedTab,
        onTabSelected = {
            selectedTab = it
        },
        applauseCount = applauseCount,
        onApplaud = {
            applauseCount++
        },
        modifier = modifier
    )
}

@Composable
fun FeedContent(
    visibleArticles: List<Article>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    showShortReadsOnly: Boolean,
    onShortReadsOnlyChange: (Boolean) -> Unit,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    applauseCount: Int,
    onApplaud: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resultCount = visibleArticles.size

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
            selectedTab = selectedTab,
            onTabSelected = onTabSelected,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        )

        Separator(
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = {
                Text("Buscar por título o autor")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    checked = showShortReadsOnly,
                    onCheckedChange = onShortReadsOnlyChange
                )

                Text("Solo lecturas cortas")
            }

            Text(
                text = if (resultCount == 1) {
                    "1 resultado"
                } else {
                    "$resultCount resultados"
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = onApplaud
            ) {
                Text("Aplaudir · $applauseCount")
            }
        }

        Separator(
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        if (visibleArticles.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("No se encontraron artículos")
                Text("Cambia la pestaña, la búsqueda o el filtro.")
            }
        } else {
            visibleArticles.forEach { articleFor ->
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