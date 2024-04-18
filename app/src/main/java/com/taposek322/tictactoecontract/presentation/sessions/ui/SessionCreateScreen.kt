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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.presentation.sessions.viewmodel.CreateSessionViewModel

@Composable
fun SessionCreateScreenRoot(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel:CreateSessionViewModel = hiltViewModel()
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
    SessionCreateScreen(
        expectedPlayer2 = viewModel.expectedPlayer2,
        expectedPlayer2Hint = stringResource(id = R.string.expectedPlayer_hint),
        ethAmount = viewModel.ethAmount,
        ethAmountHint = stringResource(id = R.string.ethAmount_hint),
        onExpectedPlayer2Change = viewModel::changeExpectedPlayer,
        onEthAmountChange = viewModel::changeEthAmount,
        loading = viewModel.loading,
        success = viewModel.success,
        onCreateButtonClick = { viewModel.createGame() },
        buttonName = stringResource(id = R.string.createGame_button_name),
        navigate = {
            navController.navigate(NavRouts.sessionWaitSecondPlayerScreen){
                viewModel.clear()
                launchSingleTop = true
            }
        }
    )
}

@Composable
fun SessionCreateScreen(
    expectedPlayer2:String,
    expectedPlayer2Hint:String,
    ethAmount:String,
    ethAmountHint:String,
    onExpectedPlayer2Change:(String)->Unit,
    onEthAmountChange:(String)->Unit,
    loading:Boolean,
    success:Boolean,
    onCreateButtonClick:()->Unit,
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
        SessionCreateInputField(
            inputValue = expectedPlayer2,
            hint = expectedPlayer2Hint,
            onValueChange = {
                onExpectedPlayer2Change(it)
            },
        )
        SessionCreateInputField(
            inputValue = ethAmount,
            hint = ethAmountHint,
            onValueChange = {
                onEthAmountChange(it)
            }
        )

        Button(
            enabled = !loading,
            onClick = onCreateButtonClick,
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
fun SessionCreateInputField(
    inputValue:String,
    hint:String,
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier
){
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
            .padding(10.dp)
    )
}

@Preview
@Composable
fun SessionCreateScreenPreview(){
    SessionCreateScreen(
        expectedPlayer2 = "",
        expectedPlayer2Hint = "Expected player",
        ethAmount = "",
        ethAmountHint = "Amount of ether to transfer",
        onExpectedPlayer2Change = {},
        onEthAmountChange = {},
        loading = false,
        success = false,
        onCreateButtonClick = { /*TODO*/ },
        buttonName = "Create",
        navigate = { /*TODO*/ })
}