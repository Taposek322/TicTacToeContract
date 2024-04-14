package com.taposek322.tictactoecontract.presentation.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.ActionsValue
import com.taposek322.tictactoecontract.presentation.viewmodel.TicTacToeViewmodel

@Composable
fun TicTacToeGrid(context:Context,modifier: Modifier = Modifier){
    val viewModel = hiltViewModel<TicTacToeViewmodel>()
    val data = viewModel.state.collectAsState()
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
                        val imgVector = when (data.value[i][j]) {
                            ActionsValue.XS -> ImageVector.vectorResource(R.drawable.baseline_xs_24)
                            ActionsValue.OS -> ImageVector.vectorResource(R.drawable.outline_os_24)
                            else -> null
                        }

                        val imgDescription = when(data.value[i][j]){
                            ActionsValue.XS -> context.getString(R.string.x_figure)
                            ActionsValue.OS -> context.getString(R.string.o_figure)
                            else -> null
                        }

                        TicTacToeContainer(
                            imageVector = imgVector,
                            imageDescription = imgDescription,
                            onClick = { viewModel.set(i,j) }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TicTacToeGridPreview(){
    val data:List<List<ActionsValue?>> = List(size =3){List(size =3){null} }
    val context = LocalContext.current
    //TicTacToeGrid(data = data, context = context, onClick = {})
}