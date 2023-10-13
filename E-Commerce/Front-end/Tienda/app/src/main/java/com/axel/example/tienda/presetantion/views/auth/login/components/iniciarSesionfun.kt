package com.axel.example.tienda.presetantion.views.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.axel.example.tienda.R
import com.axel.example.tienda.presetantion.components.DefaultButtom
import com.axel.example.tienda.presetantion.components.DefaultTextField
import com.axel.example.tienda.presetantion.components.fondoPantallaApp
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.views.auth.login.IniciarSesionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  iniciarSesion(paddingValues: PaddingValues,navController: NavHostController, vM : IniciarSesionViewModel = hiltViewModel()){
    val backGround = painterResource(id = R.drawable.fondito)
    val logo = painterResource(id = R.drawable.logo)
    val state = vM.state
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)){
        fondoPantallaApp(fondoImagen = backGround)

    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            painter = logo,
            contentDescription = null )


        Text(
            modifier = Modifier.padding(top = 7.dp),
            //poner de nombre la tienda Narcissist
            text = "Tienda",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp
        )

        //Tarjeta de formulario

        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp
            )

        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)){
                Column (
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp,
                            vertical = 20.dp
                        )
                        .verticalScroll(rememberScrollState(

                        ))
                ){
                    Text(
                        modifier= Modifier.padding(bottom = 20.dp),
                        text = "Ingresar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.correoElectronico,
                        onValueChange ={text->
                            vM.onEmailinput(text)
                        },
                        label = "Correo Electrónico",
                        icon = Icons.Default.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.contraseñaUsuario,
                        onValueChange ={text ->
                                       vM.onPasswordinput(text)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    DefaultButtom(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .padding(top = 10.dp),
                        text = "Iniciar sesión",
                        onClick = {},
                        icon = Icons.Default.ArrowForward)

                    Row(
                        modifier= Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "¿No tienes cuenta?")
                        Text(modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) },
                            text = " Registrate",
                            color= Color.Blue)

                    }




                }
            }

        }


    }

}