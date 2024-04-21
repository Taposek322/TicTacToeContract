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
import com.taposek322.tictactoecontract.presentation.connection.ui.ConnectionScreenRoot
import com.taposek322.tictactoecontract.presentation.game.ui.TicTacToeScreenRoot
import com.taposek322.tictactoecontract.presentation.sessions.ui.SessionChoiceScreenRoot
import com.taposek322.tictactoecontract.presentation.sessions.ui.SessionCreateScreenRoot
import com.taposek322.tictactoecontract.presentation.sessions.ui.SessionJoinScreenRoot
import com.taposek322.tictactoecontract.presentation.sessions.ui.SessionWaitSecondPlayerScreenRoot
import com.taposek322.tictactoecontract.presentation.theme.TicTacToeContractTheme
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
                            composable(route = NavRouts.connectionScreen) {
                                ConnectionScreenRoot(applicationContext, navController)
                            }
                        }
                        navigation(route = NavRouts.sessions, startDestination = NavRouts.sessionChooseScreen) {
                            composable(route = NavRouts.sessionChooseScreen ){
                                SessionChoiceScreenRoot(navController)
                            }
                            navigation(route = NavRouts.sessionCreate, startDestination = NavRouts.sessionCreateScreen) {
                                composable(route = NavRouts.sessionCreateScreen) {
                                    SessionCreateScreenRoot(applicationContext, navController)
                                }
                                composable(route = NavRouts.sessionWaitSecondPlayerScreen){
                                    SessionWaitSecondPlayerScreenRoot(applicationContext,navController)
                                }
                            }
                            composable(route = NavRouts.sessionJoinScreen){
                                SessionJoinScreenRoot(applicationContext,navController)
                            }
                        }
                        navigation(route = NavRouts.game, startDestination = NavRouts.gameScreen) {
                            composable(route = NavRouts.gameScreen) {
                                TicTacToeScreenRoot(applicationContext, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}