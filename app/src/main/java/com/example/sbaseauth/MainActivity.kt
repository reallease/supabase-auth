package com.example.sbaseauth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sbaseauth.ui.theme.SBaseAuthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SBaseAuthTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var showMessage by remember { mutableStateOf(false) }
    val gradientColors = listOf(Cyan, Blue, Red, Green /*...*/)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val brush = remember {
        Brush.linearGradient(
            colors = gradientColors
        )
    }
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome to Authentication", fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.padding(top = 20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            textStyle = TextStyle(brush = brush)
        )


        // visualTransformation: quando você digitar e você colocar o tipo dele
        // que nesse caso coloquei PasswordVisualTransformation() ele vai deixar
        // a senha com asteriscos (***)
        // keyboardOptions: vai ser o tipo do teclado do texto do textfield que nesse
        // caso é password, mas poderia ser email, etc, e assim ele vai se adaptando
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.padding(top = 20.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1
        )

        Spacer(
            modifier = Modifier
                .padding(top = 20.dp)
        )

        Button(onClick = { showMessage = true}) {
            Text(text = "Login")
        }

        // if(showMessage) verifica se showMessage é igual a true
        if (showMessage) {
            Toast.makeText(
                LocalContext.current,
                "Botão foi clicado!",
                Toast.LENGTH_SHORT
            ).show()
            showMessage = false // Reseta o estado após mostrar o Toast
        }

    }
}