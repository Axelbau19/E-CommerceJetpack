package com.axel.example.tienda.presetantion.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun fondoPantallaApp(fondoImagen: Painter){
    Image(
        modifier= Modifier.fillMaxSize(),
        painter = fondoImagen ,
        contentDescription =null,
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f,
            0.5f,
            0.5f,
            1f)}
        ))
}