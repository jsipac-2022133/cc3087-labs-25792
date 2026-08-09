package com.jamesipac.uvg.data

import androidx.compose.ui.graphics.Color
import com.jamesipac.uvg.model.Article

val articles=listOf(
    Article(
        author = "Daniel Herrera",
        title = "Por qué tu computadora se vuelve lenta con el tiempo",
        content = "Pequeñas decisiones de software y almacenamiento pueden afectar el rendimiento más de lo que imaginas.",
        readingMinutes = 5,
        date = "14 jul",
        avatarColor = Color.DarkGray,
        thumbnailColor = Color.Magenta
    ),
    Article(
        author = "Lucía Morales",
        title = "El código que funciona no siempre es buen código",
        content = "Hacer que un programa funcione es solo el inicio; mantenerlo simple y entendible es el verdadero reto.",
        readingMinutes = 7,
        date = "20 jul",
        avatarColor = Color.Green,
        thumbnailColor = Color.Yellow
    ),
    Article(
        author = "Andrés Castillo",
        title = "Cómo la inteligencia artificial está cambiando la programación",
        content = "Las nuevas herramientas de IA están transformando la forma en que los desarrolladores escriben, revisan y aprenden código.",
        readingMinutes = 6,
        date = "2 ago",
        avatarColor = Color.LightGray,
        thumbnailColor = Color.Blue
    )
)