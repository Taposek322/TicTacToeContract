package com.taposek322.tictactoecontract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.presentation.ui.ConnectionScreen
import com.taposek322.tictactoecontract.presentation.ui.TicTacToeScreen
import com.taposek322.tictactoecontract.presentation.ui.SessionChoiceScreen
import com.taposek322.tictactoecontract.presentation.ui.theme.TicTacToeContractTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            TicTacToeContractTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = NavRouts.connection) {
                        navigation(route = NavRouts.connection, startDestination = NavRouts.connectionScreen) {
                            composable(route = NavRouts.connectionScreen ){
                                ConnectionScreen(navController)
                            }
                            composable(route = NavRouts.sessionChoiceScreen){
                                SessionChoiceScreen(navController = navController)
                            }
                        }
                        navigation(route = NavRouts.game, startDestination = NavRouts.gameScreen) {
                            composable(route = NavRouts.gameScreen ){
                                TicTacToeScreen(context = applicationContext)
                            }
                        }
                        
                    }
                }
            }
        }
    }
}