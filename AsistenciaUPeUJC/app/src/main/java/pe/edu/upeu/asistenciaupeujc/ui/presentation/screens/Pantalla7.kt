import android.widget.ScrollView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla7() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Operaciones",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Black
                        )
                    )

                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text("Número 1") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text("Número 2") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {
                                if (num1.isNotBlank() && num2.isNotBlank()) {
                                    val valor1 = num1.toDouble()
                                    val valor2 = num2.toDouble()
                                    val suma = valor1 + valor2
                                    val resta = valor1 - valor2
                                    val multiplicacion = valor1 * valor2
                                    val division = if (valor2 != 0.0) valor1 / valor2 else Double.NaN

                                    resultado = "Suma: $suma\nResta: $resta\nMultiplicación: $multiplicacion\nDivisión: $division"
                                } else {
                                    resultado = "Por favor, ingrese números válidos en ambos campos."
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp) // Espaciado para los botones
                        ) {
                            Text(
                                text = "Calcular",
                                fontSize = 20.sp // Tamaño de fuente definido aquí
                            )
                        }

                        Button(
                            onClick = {
                                num1 = ""
                                num2 = ""
                                resultado = ""
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp) // Espaciado para los botones
                        ) {
                            Text(
                                text = "Limpiar",
                                fontSize = 20.sp // Tamaño de fuente definido aquí
                            )
                        }
                    }

                    Text(
                        text = resultado,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    )
}