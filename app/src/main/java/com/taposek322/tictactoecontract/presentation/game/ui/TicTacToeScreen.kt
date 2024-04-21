package com.taposek322.tictactoecontract.presentation.game.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.gamefield.ActionsValue
import com.taposek322.tictactoecontract.presentation.game.viewmodel.GameResult
import com.taposek322.tictactoecontract.presentation.game.viewmodel.TicTacToeViewmodel
import java.lang.reflect.Array.set
import java.math.BigInteger

@Composable
fun TicTacToeScreenRoot(
    context:Context,
    navController: NavController,
    modifier :Modifier = Modifier,
    viewModel: TicTacToeViewmodel = hiltViewModel()
) {
    if(viewModel.error) {
        LaunchedEffect(key1 = viewModel.error) {
            viewModel.errorMessage.collect {
                Toast.makeText(
                    context,
                    it.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    val winnerMessage = when (viewModel.winner) {
        GameResult.Win -> stringResource(id = R.string.winner_message)
        GameResult.Lose -> stringResource(id = R.string.looser_message)
        GameResult.Draw -> stringResource(id = R.string.draw_message)
    }
        
    TicTacToeGrid(
        data = viewModel.gamefield,
        onClick = viewModel::set,
        whosTurn = viewModel.whosTurn,
        loading = viewModel.loading,
        gameFinished = viewModel.gameFinished,
        navigate = {
            navController.navigate(NavRouts.sessions){
                popUpTo(NavRouts.sessionChooseScreen)
                launchSingleTop = true
            }
        },
        buttonText = stringResource(id = R.string.back_to_sessions_button_name),
        resultString = winnerMessage,
        betAmountString = stringResource(id = R.string.bet_amount_message,viewModel.betAmount),
        yourTurnMessage = stringResource(id = R.string.your_turn_message),
        opponentTurnMessage = stringResource(id = R.string.opponent_turn_message),
        xsIcon = ImageVector.vectorResource(R.drawable.baseline_xs_24),
        xsDescription =  stringResource(R.string.x_figure),
        osIcon = ImageVector.vectorResource(R.drawable.outline_os_24),
        osDescription = stringResource(R.string.o_figure),
        modifier = modifier
    )
}

@Composable
fun TicTacToeGrid(
    data: List<ActionsValue?>,
    onClick: (BigInteger) -> Unit,
    whosTurn: Boolean,
    loading:Boolean,
    gameFinished:Boolean,
    navigate:()->Unit,
    buttonText: String,
    resultString: String,
    betAmountString: String,
    yourTurnMessage:String,
    opponentTurnMessage:String,
    xsIcon:ImageVector,
    xsDescription:String,
    osIcon:ImageVector,
    osDescription:String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .fillMaxSize()
    ) {
        val text = if(whosTurn) yourTurnMessage else opponentTurnMessage
        Text(
            text = text,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
        for (i in 0..2) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .weight(1f)
                    .padding(5.dp)
            ) {
                for (j in 0..2) {
                    Column(
                        modifier = modifier
                            .weight(1f)
                            .padding(5.dp)
                    ) {
                        val imgVector = when (data[3*i+j]) {
                            ActionsValue.XS -> xsIcon
                            ActionsValue.OS -> osIcon
                            else -> null
                        }

                        val imgDescription = when(data[3*i+j]){
                            ActionsValue.XS -> xsDescription
                            ActionsValue.OS -> osDescription
                            else -> null
                        }

                        TicTacToeContainer(
                            imageVector = imgVector,
                            whosTurn = whosTurn,
                            loading = loading,
                            imageDescription = imgDescription,
                            onClick = {
                                onClick((3*i+j).toBigInteger())
                            }
                        )
                    }
                }
            }
        }
        if(gameFinished){
            ShowWinnerDialog(
                buttonText = buttonText,
                onClick = navigate,
                resultString = resultString,
                betAmountString = betAmountString
            )
        }
    }
}

@Composable
fun ShowWinnerDialog(
    buttonText:String,
    onClick: () -> Unit,
    resultString:String,
    betAmountString:String,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = {}) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(5.dp)
        ) {
            Text(
                text = resultString,
                modifier = modifier
                    .padding(5.dp)
            )
            Text(
                text = betAmountString,
                modifier = modifier
                    .padding(5.dp)
            )
            Button(onClick = {
                onClick()
            }) {
                Text(
                    text = buttonText,
                    modifier = modifier
                        .padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun TicTacToeContainer(
    imageVector:ImageVector?,
    imageDescription:String?,
    whosTurn: Boolean,
    loading: Boolean,
    onClick:()->Unit,
    modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(5.dp)
            .clickable(
                enabled = ((imageVector == null) && (loading.not()) && whosTurn)
            ) {
                onClick()
            }
    ) {
        Log.d("TicTacToeContainer","Bool result:${(imageVector == null) && !loading && whosTurn}")
        Log.d("TicTacToeContainer","Image vect result:${(imageVector == null)}")
        Log.d("TicTacToeContainer","Loading result:${loading.not()}")
        Log.d("TicTacToeContainer","WhosTurn result:${whosTurn}")
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ){
            imageVector?.let {
                Icon(
                    imageVector = imageVector,
                    contentDescription = imageDescription,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
private fun TitTacPreview(){
    TicTacToeGrid(
        data = List(9){null},
        onClick = {},
        whosTurn = false,
        loading = false,
        gameFinished = true,
        navigate = {},
        buttonText = "Back to main menu",
        resultString = "You won!",
        betAmountString = "Bet: 1 eth",
        yourTurnMessage = "Your turn",
        opponentTurnMessage = "Opponent turn",
        xsIcon = Icons.Outlined.AddCircle,
        xsDescription =  "X",
        osIcon = Icons.Outlined.Clear,
        osDescription = "O",
    )
}