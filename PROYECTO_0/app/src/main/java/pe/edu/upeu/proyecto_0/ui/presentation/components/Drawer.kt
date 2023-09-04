package pe.edu.upeu.proyecto_0.ui.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.edu.upeu.proyecto_0.R
import pe.edu.upeu.proyecto_0.ui.navigation.Destinations
import pe.edu.upeu.proyecto_0.ui.navigation.currentRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: DrawerState,
    navController: NavHostController,
    items: List<Destinations>
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Bg Image",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )
        val currentRoute = currentRoute(navController)
        items.forEach { item ->
            DrawerItem(
                item = item, selected = currentRoute ==
                item.route
            ) {
                navController.navigate(item.route) {
                    launchSingleTop = true
                }
                scope.launch {
                    scaffoldState.close()
                }
            }
        }
    }
}


