package com.victor.coolcamara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.victor.coolcamara.ui.theme.CoolCamaraTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}


@Composable
fun AlarmCard(){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.size(width = 360.dp, height = 512.dp),
    ) {


        val primaryColor = Color(0xFF6750A4)

        Row (
            modifier = Modifier.padding(all=5.dp)
        ){
            Column(modifier = Modifier.padding(all=5.dp)) {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .drawBehind {
                            drawCircle(
                                color = primaryColor,
                                radius = this.size.maxDimension
                            )
                        },
                    text = "A",
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier.padding(all=5.dp)
            ) {
                Text(text = "Alarma 1")
                Text(text = "Alarma")
            }

            Spacer(modifier = Modifier.size(width = 190.dp, height = 0.dp))

            Column(modifier = Modifier.padding(all=5.dp), horizontalAlignment = Alignment.End) {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Options")
                }
            }
        }


        Row (
            modifier = Modifier.padding(all=5.dp)
        ) {
            Column(modifier = Modifier.clickable(onClick = { })) {
                Image(
                    painter = painterResource(R.drawable.playing_videogame),
                    contentDescription = null, // decorative
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(256.dp)
                        .fillMaxWidth()
                )
            }
        }


        Row(
            modifier = Modifier.padding(all=5.dp)
        ) {
            Text(text = "Alarma 1", fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier.padding(all=5.dp)
        ) {
            Text(text = "Subtitulo alarma")
        }

        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))

        Row(
            modifier = Modifier.padding(all=5.dp)
        ) {
            Text(text = "Descripción de la alarma")
        }

        Row(
            modifier = Modifier.padding(all=5.dp)
        ) {
            var checked by remember { mutableStateOf(true) }

            Spacer(modifier = Modifier.size(width = 280.dp, height = 0.dp))

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(toolBarTitle:String) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
        ),
        title = {
            Text(text = toolBarTitle)
        }
    )

}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CoolCamaraTheme {
        Main()
    }
}

@Composable
fun AppPaginator() {
    Row {
        Column() {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
            }
        }

        Column() {
            LinearProgressIndicator(progress = 0.7f)
        }

        Column() {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "Right     ")
            }
        }
    }
}



@Composable
fun Main() {
    Scaffold(
        topBar = {
            AppTopBar(toolBarTitle = "Alarmas")
        },
        content =
            { padding ->
                Surface(
                    modifier = Modifier.padding(padding),
                ) {
                    Column(Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Row {
                            AlarmCard()
                        }

                        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

                        Row{
                            AppPaginator()
                        }
                    }
                }
            }
    )
}