package org.kodein.playground.common
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance
import org.kodein.di.with

val commonDI = DI.Module("CommonModule") {
    constant("me") with "Romain"
}

@Composable
fun App() {
    subDI({
        constant("me", overrides = true) with "Salomon"
    }) { MyButton() }
}

@Composable
fun MyButton() {
    val di = LocalDI.current
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, ${di.direct.instance<String>("me")}"
        }) {
            Text(text)
        }
    }
}