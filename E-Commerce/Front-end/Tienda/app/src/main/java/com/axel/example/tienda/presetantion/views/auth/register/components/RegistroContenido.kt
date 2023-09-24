package com.axel.example.tienda.presetantion.views.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axel.example.tienda.R
import com.axel.example.tienda.presetantion.components.DefaultButtom
import com.axel.example.tienda.presetantion.components.DefaultTextField
import com.axel.example.tienda.presetantion.components.fondoPantallaApp

@Composable
fun RegistroContenido(paddingValues: PaddingValues){
    val fondoImagen = painterResource(id = R.drawable.fondito)
    val usuarioImagen = painterResource(id = R.drawable.user_image)
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()){
        fondoPantallaApp(fondoImagen = fondoImagen)
        Column(
            modifier= Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopBanner(usuarioImagen = usuarioImagen)
            Spacer(modifier = Modifier.weight(1f))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                )
            ){
                Column (modifier = Modifier
                    .background(Color.White)
                    .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
                    Text(text = "REGISTRARSE",
                        modifier= Modifier
                            .padding(vertical = 20.dp)
                            .padding(bottom = 5.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color= Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Nombres" ,
                        icon =Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Apellidos" ,
                        icon =Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Correo electrónico" ,
                        icon =Icons.Outlined.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Contraseña" ,
                        icon =Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Confirmar contraseña" ,
                        icon =Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange =  {},
                        label ="Teléfono" ,
                        icon =Icons.Default.Call,
                        keyboardType = KeyboardType.Number
                    )
                    DefaultButtom(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 15.dp),
                        text = "Confirmar",
                        onClick = {  },
                        icon = Icons.Default.Check)
                }

            }
        }
    }
}

