package pe.edu.upeu.proyecto_0

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.edu.upeu.proyecto_0.ui.navigation.Destinations
import pe.edu.upeu.proyecto_0.ui.navigation.NavigationHost
import pe.edu.upeu.proyecto_0.ui.presentation.components.Drawer
import pe.edu.upeu.proyecto_0.ui.presentation.components.TopBar
import pe.edu.upeu.proyecto_0.ui.theme.PROYECTO_0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            AsistenciaUPeUJCTheme {
                // Superficie que utiliza el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(darkMode = darkMode)
                }
            }
        }
    }
}

//aqui ?


/*@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    darkMode: MutableState<Boolean>,
    // themeType: MutableState<ThemeType>
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }

    val navigationItems = listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3,
        Destinations.Pantalla4
    )

    val navigationItems2 = listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3
    )

    ModalNavigationDrawer(
        drawerContent = {
            Drawer(
                scope = scope,
                drawerState = drawerState,
                navController = navController,
                items = navigationItems
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    scope = scope,
                    drawerState = drawerState,
                    openDialog = { openDialog.value = true },
                    displaySnackBar = {
                        scope.launch {

                        }
                    }
                )
            }, modifier = Modifier
        ) {
            NavigationHost(navController, darkMode)
        }
        //
    }

    Dialog (showDialog=openDialog.value, demissDialog={
    openDialog.value = false })

}

*/

//aqui
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
    PROYECTO_0Theme {
        Greeting("Android")
    }
}