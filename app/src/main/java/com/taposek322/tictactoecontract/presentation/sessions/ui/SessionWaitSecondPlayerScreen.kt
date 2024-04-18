package com.taposek322.tictactoecontract.presentation.sessions.ui

import android.content.ClipData
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.presentation.sessions.viewmodel.SessionWaitSecondPlayerViewModel

@Composable
fun SessionWaitSecondPlayerScreenRoot(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel:SessionWaitSecondPlayerViewModel = hiltViewModel()
){
    val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager

    SessionWaitSecondPlayerScreen(
        waitPlayerString = stringResource(id = R.string.waiting_second_player),
        contractAddressText = stringResource(id = R.string.contract_address_text),
        contractAddress = viewModel.contractAddress,
        success = viewModel.success,
        copyClick = {
            val clipData = ClipData.newPlainText("contractAddress",viewModel.contractAddress)
            clipboardManager.setPrimaryClip(clipData)
        },
        navigate = {
            navController.navigate(NavRouts.sessionWaitSecondPlayerScreen){
                viewModel.clear()
                launchSingleTop = true
            }
        })
}

@Composable
fun SessionWaitSecondPlayerScreen(
    waitPlayerString:String,
    contractAddressText:String,
    contractAddress:String,
    success:Boolean,
    copyClick:()->Unit,
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
        Text(
            text = waitPlayerString,
            modifier = modifier
                .padding(10.dp)
        )
        Text(
            text = contractAddressText,
            modifier = modifier
                .padding(10.dp)
        )
        CopyableText(
            text = contractAddress,
            onClick = {copyClick()},
            modifier = modifier
                .padding(10.dp)
        )
    }
    if(success){
        navigate()
    }
}

@Composable
fun CopyableText(
    text:String,
    onClick:()->Unit,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}

@Preview
@Composable
private fun SessionWaitSecondPlayerScreenPreview(){
    SessionWaitSecondPlayerScreen(
        waitPlayerString = "Waiting for second player",
        contractAddressText = "Address of contract to join: ",
        contractAddress = "",
        copyClick = {},
        success = false,
        navigate = { /*TODO*/ })
}