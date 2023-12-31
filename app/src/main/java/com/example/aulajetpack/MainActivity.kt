package com.example.aulajetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aulajetpack.ui.theme.AulaJetpackTheme
import com.example.aulajetpack.ui.theme.DebugButtonCollors
import com.example.aulajetpack.ui.theme.ErrorButtonCollors
import com.example.aulajetpack.ui.theme.InfoButtonCollors
import com.example.aulajetpack.ui.theme.WarningButtonCollors

const val TAG = "AppCompose"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit,
){
    ElevatedButton(onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Action") {

    }
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("App JetpackCompose")
            ActionButton(text = "Debug",
                buttonColors = DebugButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d(TAG, "App: Você clicou em DEBUG...")
            }
            ActionButton(text = "Info",
                buttonColors = InfoButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "App: Você clicou em INFO...")
            }
            ActionButton(text = "Warning",
                buttonColors = WarningButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(TAG, "App: Você clicou em WARNING...")
            }
            ActionButton(text = "Error!",
                buttonColors = ErrorButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Você clicou em ERROR...")
                } catch (ex: Exception) {
                    Log.e(TAG, "${ex.message}", )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppPreview(){
    AulaJetpackTheme(){
        App()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Welcome to $name!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AulaJetpackTheme() {
        Greeting("App JetpackCompose")
    }
}