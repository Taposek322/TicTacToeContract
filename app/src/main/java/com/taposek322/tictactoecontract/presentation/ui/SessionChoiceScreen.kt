package com.taposek322.tictactoecontract.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.data.EtherRepositoryImpl
import com.taposek322.tictactoecontract.presentation.viewmodel.ConnectionViewModel
import com.taposek322.tictactoecontract.presentation.viewmodel.ConnectionViewModelFactory

@Composable
fun SessionChoiceScreen(navController: NavController,modifier: Modifier = Modifier){
    val connectionViewModel: ConnectionViewModel = viewModel(factory = ConnectionViewModelFactory(
        EtherRepositoryImpl.get())
    )

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var age by rememberSaveable {
        mutableStateOf("")
    }

    var amount by rememberSaveable {
        mutableStateOf("")
    }

    var addrs by rememberSaveable {
        mutableStateOf("")
    }

    var ethrAmount by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        Button(onClick = { connectionViewModel.createContract() }) {
            Text(text = "Create contract")
        }
        TextField(value = name, onValueChange = {name = it})
        TextField(value = age, onValueChange = {age = it})
        TextField(value = amount, onValueChange = {amount = it})
        TextField(value = addrs, onValueChange = {addrs = it})
        Button(onClick = { connectionViewModel.registerEmploy(name,age.toBigInteger(),amount.toBigInteger(),addrs) }) {
            Text(text = "Register")
        }
        Button(onClick = { connectionViewModel.getEmploy()}) {
            Text("Employ")
        }
        Button(onClick = { connectionViewModel.getEmployNum() }) {
            Text("Num")
        }
        TextField(value = ethrAmount, onValueChange = {ethrAmount = it})
        Button(onClick = { connectionViewModel.transferEth(ethrAmount.toBigDecimal()) }) {
            Text("Transfer")
        }
        Button(onClick = { connectionViewModel.getContractBalance() }) {
            Text("Balance")
        }
    }
}