package com.taposek322.tictactoecontract.presentation.sessions.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.presentation.sessions.viewmodel.JoinSessionViewModel

@Composable
fun SessionJoinScreenRoot(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: JoinSessionViewModel = hiltViewModel()
){
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
    SessionJoinScreen(
        contractAddress = viewModel.contractAddress,
        contractAddressHint = stringResource(id = R.string.contract_address_hint),
        contractAddressErrorMessage = viewModel.contractAddressErrorMessage,
        ethAmount = viewModel.ethAmount,
        ethAmountHint = stringResource(id = R.string.ethAmount_hint),
        ethAmountErrorMessage = viewModel.ethAmountErrorMessage,
        onContractAddressChange = viewModel::changeContractAddress,
        onEthAmountChange = viewModel::changeEthAmount,
        loading = viewModel.loading,
        success = viewModel.success,
        onJoinButtonClick = { viewModel.joinGame() },
        buttonName = stringResource(id = R.string.joinGame_button_name),
        navigate = {
            navController.navigate(NavRouts.game){
                popUpTo(navController.graph.findStartDestination().id){
                    inclusive = true
                }
                launchSingleTop = true
            }
        },
    )
}

@Composable
fun SessionJoinScreen(
    contractAddress:String,
    contractAddressHint:String,
    contractAddressErrorMessage:String?,
    ethAmount:String,
    ethAmountHint:String,
    ethAmountErrorMessage:String?,
    onContractAddressChange:(String)->Unit,
    onEthAmountChange:(String)->Unit,
    loading:Boolean,
    success:Boolean,
    onJoinButtonClick:()->Unit,
    buttonName:String,
    navigate:()->Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        SessionJoinInputField(
            inputValue = contractAddress,
            hint = contractAddressHint,
            errorMessage = contractAddressErrorMessage,
            onValueChange = {
                onContractAddressChange(it)
            },
        )
        SessionJoinInputField(
            inputValue = ethAmount,
            hint = ethAmountHint,
            errorMessage = ethAmountErrorMessage,
            onValueChange = {
                onEthAmountChange(it)
            },
        )

        Button(
            enabled = !loading,
            onClick = onJoinButtonClick,
            modifier = modifier
                .padding(10.dp)
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = modifier
                )
            } else {
                Text(text = buttonName)
            }
        }
        if (success) {
            navigate()
        }
    }
}

@Composable
fun SessionJoinInputField(
    inputValue:String,
    hint:String,
    errorMessage:String?,
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = inputValue,
            onValueChange = {onValueChange(it)},
            placeholder = {
                Text(
                    text = hint,
                    modifier = modifier
                )
            },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
        )
        if(errorMessage!=null){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = modifier
                    .align(Alignment.End)
            )
        }
    }
}