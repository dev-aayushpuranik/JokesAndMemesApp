package com.aayushpuranik.jokesandmemesapp.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aayushpuranik.jokesandmemesapp.core.Destination
import com.aayushpuranik.jokesandmemesapp.views.theme.JokesAndMemesAppTheme
import com.aayushpuranik.jokesandmemesapp.views.ui.HomeScreen
import com.aayushpuranik.jokesandmemesapp.views.ui.SecondScreen
import com.aayushpuranik.jokesandmemesapp.views.viewModels.JokesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokesAndMemesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationHandler(innerPadding)
                }
            }
        }
    }

    @Composable
    fun NavigationHandler(paddingValues: PaddingValues) {
        val navController: NavHostController = rememberNavController()

        NavHost(navController = navController,
            modifier = Modifier.padding(paddingValues),
            startDestination = Destination.Home) {

            composable<Destination.Home> {
                val viewModel: JokesViewModel = hiltViewModel()
                HomeScreen(navController, viewModel)
            }
            composable<Destination.Second> { SecondScreen(navController) }
        }
    }


}

