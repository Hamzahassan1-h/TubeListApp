package com.example.tubelistapp


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.navRoutes.navRoutes
import com.example.common.routes.TubeListNavRoutes
import com.example.tubelistapp.ui.compose.TubeList.TubeDetailScreen
import com.example.tubelistapp.ui.compose.TubeList.TubeListScreen
import com.example.tubelistapp.ui.compose.nav.routes.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                App(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(navController: NavHostController) {
    val topBarState = remember { mutableStateOf(false) }
    val bottomBarState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarTitle = remember(currentRoute) {
        when (currentRoute) {
            navRoutes.ROUTE_TUBE -> "Tube Lists"
            navRoutes.Tube.route -> "Tube Details"
            else -> "Details"
        }
    }

//    when (navBackStackEntry?.destination?.route) {
//        navRoutes.Home.route,
//        navRoutes.Home.route -> {
//            bottomBarState.value = true
//            topBarState.value = false
//        }
//
//        else -> {
//            bottomBarState.value = false
//            topBarState.value = true
//        }
//    }

    Scaffold(
        topBar = {
            if (topBarState.value) {
                TopAppBar(
                    //backgroundColor = MaterialTheme.colorScheme.primary,
                    title = { Text(text = topBarTitle) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (bottomBarState.value) {
                BottomAppBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = navRoutes.ROUTE_HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(navRoutes.ROUTE_HOME) {
                HomeScreen(navController = navController)
            }
            composable(navRoutes.ROUTE_TUBE) {
                TubeListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = navRoutes.Tube.route,
                arguments = navRoutes.Tube.arguments
            ) {
                TubeDetailScreen(TubeListNavRoutes.Details.fromEntry(it))
            }


        }
    }
}

@Composable
fun BottomAppBar(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

        }
    }
}
