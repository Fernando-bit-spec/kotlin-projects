package com.example.caraoucoroa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caraoucoroa.ui.theme.CaraOuCoroaTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaraOuCoroaTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaraOuCoroa(modifier = Modifier.padding(paddingValues = innerPadding))
                }
            }


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaraOuCoroaTheme {
        Greeting("Android")
    }


}

@Composable
fun CaraOuCoroa(modifier: Modifier = Modifier) {
    var resultado by remember { mutableStateOf(value = "") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jogo cara ou coroa")
        Spacer(Modifier.height(height = 16.dp))
        Button(onClick = {
            resultado = if (Random().nextBoolean()) "Cara" else "Coroa"
        }) {
            Text(text = "jogar")
        }
        if(resultado.isNotEmpty()){
            Spacer(Modifier.height (height = 24.dp))
            Text(text = resultado)
        }

    }


}