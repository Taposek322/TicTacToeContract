package com.taposek322.tictactoecontract.presentation.connection.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.data.repository.EtherRepositoryImpl
import com.taposek322.tictactoecontract.presentation.connection.viewmodel.ConnectionViewModel
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager


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

        ConnectionInputField(inputValue = connectionString, hint = connectionStringHint, onValueChange = onConnectionStringChange)
        ConnectionInputField(inputValue = chainId, hint = chainIdHint, onValueChange = onChainIdStringChange)
        ConnectionInputField(inputValue = privateKey, hint = privateKeyHint, onValueChange = onPrivateKeyStringChange)

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
private fun ConnectionScreenPreview(){

}