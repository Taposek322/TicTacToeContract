package com.taposek322.tictactoecontract.presentation.sessions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.R

//import com.taposek322.tictactoecontract.presentation.connection.viewmodel.ConnectionViewModelFactory

@Composable
fun SessionChoiceScreenRoot(navController: NavController,modifier: Modifier = Modifier){
    SessionChoiceScreen(
        navToCreate = {
            navController.navigate(NavRouts.sessionCreate)
        },
        navToJoin = {
            navController.navigate(NavRouts.sessionJoinScreen)
        },
        createButtonName = stringResource(id = R.string.createGame_button_name),
        joinButtonName = stringResource(id = R.string.joinGame_button_name),
        modifier = modifier
    )
}

@Composable
fun SessionChoiceScreen(
    navToCreate:()->Unit,
    navToJoin:()->Unit,
    createButtonName:String,
    joinButtonName:String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Button(
            onClick = {
                navToCreate()
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = createButtonName,
                modifier = modifier
                    .padding(10.dp)
            )
        }

        Button(
            onClick = {
                navToJoin()
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = joinButtonName,
                modifier = modifier
                    .padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SessionChoiceScreenPreview(){
    SessionChoiceScreen(navToCreate = { /*TODO*/ }, navToJoin = { /*TODO*/ }, createButtonName = "Create game", joinButtonName = "Join game")
}