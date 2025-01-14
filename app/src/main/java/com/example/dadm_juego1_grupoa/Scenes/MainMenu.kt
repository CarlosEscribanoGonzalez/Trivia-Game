package com.example.dadm_juego1_grupoa.Scenes

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import org.w3c.dom.Text

//Contenido de la escena Start Screen
@Composable
fun BodyContent(navController: NavController){
    //ESTILOS
    val colors = listOf(
        MaterialTheme.colorScheme.background, // Azul claro
        MaterialTheme.colorScheme.surface // Color rosado claro
    ) // Colores del degradado
    val brush = Brush.linearGradient(colors)


    //VARIABLES
    val context = LocalContext.current


    //SONIDOS
    //no implementado porque el R.raw.click aun no me funciona bien
//    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.click) }


    //CUERPO DE UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background( // Aplica el gradiente de fondo
                brush = brush
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText("TRIVIAL GAME",66,Modifier)
        //Titulo del juego

        CustomElevatedButton("Jugar",onClick = {
            //FUNCION DE PASO ESCENAS CON navController (recordar usar el mediaPlayer?.start justo después)
            navController.navigate(Screen.GameOptions.route)
        },) { }
        CustomElevatedButton("Ranking",onClick = {
            navController.navigate(Screen.Ranking.route)
            //FUNCION DE PASO ESCENAS CON navController (recordar usar el mediaPlayer?.start justo después)

        },) { }
        CustomElevatedButton("Salir",onClick = {
            (context as? Activity)?.finish()
        },) { }
    }
}


@Composable
fun CustomElevatedButton(text: String, onClick: () -> Unit, function: () -> Unit) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
            ,
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(5.dp, MaterialTheme.colorScheme.secondary),
        colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary

        )
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Serif,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}



@Composable
fun CustomText(text: String, sizeText:Int,modifier: Modifier)  {
    Box(
        contentAlignment = Alignment.Center,
        //modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Serif,
            style = TextStyle(
                fontSize = sizeText.sp,
                fontWeight = FontWeight.Bold,
            ),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier//.padding(16.dp)
                .offset(1.dp, 1.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = text,
            fontFamily = FontFamily.Serif,
            style = TextStyle(
                fontSize = sizeText.sp,
                fontWeight = FontWeight.Bold,
            ),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.offset(-1.dp, -1.dp),
            textAlign = TextAlign.Center,
        )
    }
}
