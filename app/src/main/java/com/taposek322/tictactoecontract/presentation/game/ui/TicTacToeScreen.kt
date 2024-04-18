package com.taposek322.tictactoecontract.presentation.game.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.util.ActionsValue
import com.taposek322.tictactoecontract.presentation.game.viewmodel.TicTacToeViewmodel
import java.math.BigInteger

@Composable
fun TicTacToeScreenRoot(
    context:Context,
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
    TicTacToeGrid(
        data = viewModel.state.collectAsState(),
        onClick = viewModel::set,
        xsIcon = ImageVector.vectorResource(R.drawable.baseline_xs_24),
        xsDescription =  stringResource(R.string.x_figure),
        osIcon = ImageVector.vectorResource(R.drawable.outline_os_24),
        osDescription = stringResource(R.string.o_figure),
        modifier = modifier
    )
}

@Composable
fun TicTacToeGrid(
    data: State<List<ActionsValue?>>,
    onClick: (BigInteger) -> Unit,
    xsIcon:ImageVector,
    xsDescription:String,
    osIcon:ImageVector,
    osDescription:String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .fillMaxSize()
    ) {
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
                        val imgVector = when (data.value[3*i+j]) {
                            ActionsValue.XS -> xsIcon
                            ActionsValue.OS -> osIcon
                            else -> null
                        }

                        val imgDescription = when(data.value[3*i+j]){
                            ActionsValue.XS -> xsDescription
                            ActionsValue.OS -> osDescription
                            else -> null
                        }

                        TicTacToeContainer(
                            imageVector = imgVector,
                            imageDescription = imgDescription,
                            onClick = {
                                onClick((3*i+j).toBigInteger())
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TicTacToeContainer(imageVector:ImageVector?,imageDescription:String?,onClick:()->Unit,modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(5.dp)
            .clickable(enabled = (imageVector == null)) {
                onClick()
            }
    ) {
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