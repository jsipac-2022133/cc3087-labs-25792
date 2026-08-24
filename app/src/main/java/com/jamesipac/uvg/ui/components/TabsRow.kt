package com.jamesipac.uvg.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TabsRow(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier =Modifier
){
    Row(
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "Para ti",
            modifier = Modifier.clickable {
                onTabSelected("Para ti")
            },
            fontWeight = if (selectedTab == "Para ti") {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },
            color = if (selectedTab == "Para ti") {
                Color.Black
            } else {
                Color.Gray
            }
        )
        Text(
            text = "Siguiendo",
            modifier = Modifier.clickable {
                onTabSelected("Siguiendo")
            },
            color = if (selectedTab == "Siguiendo") {
                Color.Black
            } else {
                Color.Gray
            },
            fontWeight = if (selectedTab == "Siguiendo") {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )
        Text(
            text = "Destacados",
            modifier = Modifier.clickable {
                onTabSelected("Destacados")
            },
            color = if (selectedTab == "Destacados") {
                Color.Black
            } else {
                Color.Gray
            },
            fontWeight = if (selectedTab == "Destacados") {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )
    }
}