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
        expectedPlayer2ErrorMessage = viewModel.expectedPlayer2ErrorMessage,
        ethAmount = viewModel.ethAmount,
        ethAmountHint = stringResource(id = R.string.ethAmount_hint),
        ethAmountErrorMessage = viewModel.ethAmountErrorMessage,
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
        },
    )
}

@Composable
fun SessionCreateScreen(
    expectedPlayer2:String,
    expectedPlayer2Hint:String,
    expectedPlayer2ErrorMessage:String?,
    ethAmount:String,
    ethAmountHint:String,
    ethAmountErrorMessage:String?,
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
            errorMessage = expectedPlayer2ErrorMessage,
            onValueChange = {
                onExpectedPlayer2Change(it)
            },
        )
        SessionCreateInputField(
            inputValue = ethAmount,
            hint = ethAmountHint,
            errorMessage = ethAmountErrorMessage,
            onValueChange = {
                onEthAmountChange(it)
            },
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

@Preview
@Composable
fun SessionCreateScreenPreview(){
    SessionCreateScreen(
        expectedPlayer2 = "",
        expectedPlayer2Hint = "Expected player",
        expectedPlayer2ErrorMessage = "error",
        ethAmount = "",
        ethAmountHint = "Amount of ether to transfer",
        ethAmountErrorMessage = null,
        onExpectedPlayer2Change = {},
        onEthAmountChange = {},
        loading = false,
        success = false,
        onCreateButtonClick = { /*TODO*/ },
        buttonName = "Create",
        navigate = { /*TODO*/ })
}