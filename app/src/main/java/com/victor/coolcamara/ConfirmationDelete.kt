package com.victor.coolcamara

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victor.coolcamara.ui.theme.CoolCamaraTheme

class ConfirmationDelete : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoolCamaraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainConfirmationDelete()
                }
            }
        }
    }
}

@Composable
fun MainConfirmationDelete() {
    Scaffold(
        topBar = {
            AppTopBar(toolBarTitle = "Confirmación")
        },
        content =
        { padding ->
            Surface(
                modifier = Modifier.padding(padding),
            ) {
                Column(Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row {
                        Text(text = "¿Estás seguro de eliminar Alarma 1?")
                    }

                    Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

                    Row{
                        Column (horizontalAlignment = Alignment.Start){
                            val context = LocalContext.current

                            Button(
                                onClick = {
                                    context.startActivity(Intent(context, DeleteAlarm::class.java))
                                },
                                modifier =  Modifier.size(width = 120.dp,height = 45.dp)
                            ) {
                                Text(text = "Cancelar")
                            }
                        }

                        Column (horizontalAlignment = Alignment.End){
                            val context = LocalContext.current

                            Button(
                                onClick = {
                                    context.startActivity(Intent(context, MainActivity::class.java))
                                },
                                modifier =  Modifier.size(width = 120.dp,height = 45.dp)
                            ) {
                                Text(text = "Eliminar")
                            }
                        }

                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CoolCamaraTheme {
        MainConfirmationDelete()
    }
}