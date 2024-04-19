package com.taposek322.tictactoecontract.presentation.connection.ui

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
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.presentation.connection.viewmodel.ConnectionViewModel


@Composable
fun ConnectionScreenRoot(
    context: Context,
    navController: NavController,
    modifier:Modifier = Modifier,
    viewModel: ConnectionViewModel = hiltViewModel()
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
    ConnectionScreen(
        connectionString = viewModel.connectionString,
        chainId = viewModel.chainId,
        privateKey = viewModel.privateKey,
        connectionStringErrorMessage = viewModel.connectionStringValidationErrorMessage,
        chainIdStringErrorMessage = viewModel.chainIdValidationErrorMessage,
        privateKeyStringErrorMessage = viewModel.privateKeyValidationErrorMessage,
        connectionStringHint = stringResource(id = R.string.urladdress_textfield_name),
        chainIdHint = stringResource(id = R.string.chaindid_textfiled_name),
        privateKeyHint = stringResource(id = R.string.privatekey_textfield_name),
        onConnectionStringChange = viewModel::changeConnectionString,
        onChainIdStringChange = viewModel::changeChainId,
        onPrivateKeyStringChange = viewModel::changePrivateKey,
        success = viewModel.success,
        loading = viewModel.loading,
        navigate = {
                   navController.navigate(NavRouts.sessions){
                       viewModel.clear()
                       launchSingleTop = true
                   }
        },
        onButtonClick = {
                            viewModel.connect()
        },
        buttonText = stringResource(id = R.string.connect_button_name),
        modifier = modifier
            .padding(10.dp)
    )
}

@Composable
fun ConnectionScreen(
    connectionString:String,
    chainId:String,
    privateKey:String,
    connectionStringHint:String,
    chainIdHint:String,
    privateKeyHint:String,
    connectionStringErrorMessage:String?,
    chainIdStringErrorMessage:String?,
    privateKeyStringErrorMessage:String?,
    onConnectionStringChange:(String)->Unit,
    onChainIdStringChange:(String)->Unit,
    onPrivateKeyStringChange:(String)->Unit,
    success:Boolean,
    loading:Boolean,
    navigate:()->Unit,
    onButtonClick:()->Unit,
    buttonText:String,
    modifier: Modifier = Modifier,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    )
    {
        ConnectionInputField(
            inputValue = connectionString,
            hint = connectionStringHint,
            errorMessage = connectionStringErrorMessage,
            onValueChange = onConnectionStringChange,
        )
        ConnectionInputField(
            inputValue = chainId,
            hint = chainIdHint,
            errorMessage = chainIdStringErrorMessage,
            onValueChange = onChainIdStringChange,
        )
        ConnectionInputField(
            inputValue = privateKey,
            hint = privateKeyHint,
            errorMessage = privateKeyStringErrorMessage,
            onValueChange = onPrivateKeyStringChange,
        )

        Button(
            enabled = !loading,
            onClick = onButtonClick,
            modifier = modifier
                .padding(10.dp)
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = modifier
                )
            } else {
                Text(text = buttonText)
            }
        }
        if (success) {
            navigate()
        }
    }
}

@Composable
fun ConnectionInputField(
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
private fun ConnectionScreenPreview(){

}