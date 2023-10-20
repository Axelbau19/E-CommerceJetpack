package com.axel.example.tienda.presetantion.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButtom(modifier: Modifier,
                  text:String,
                  onClick: () -> Unit,
                  icon: ImageVector){
    Button(
        modifier = modifier,
        onClick = onClick ) {
        Icon(imageVector = icon ,
            contentDescription =null)
        Text(text = text)

    }
}