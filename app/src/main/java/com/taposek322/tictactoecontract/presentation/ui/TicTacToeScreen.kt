package com.taposek322.tictactoecontract.presentation.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.taposek322.tictactoecontract.presentation.viewmodel.TicTacToeViewmodel

@Composable
fun TicTacToeScreen(context:Context,modifier :Modifier = Modifier) {
    TicTacToeGrid(context = context, modifier = modifier)
}