package com.taposek322.tictactoecontract.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.taposek322.tictactoecontract.Navigation.NavRouts
import com.taposek322.tictactoecontract.data.EtherRepositoryImpl
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager


@Composable
fun ConnectionScreen(navController: NavController, modifier:Modifier = Modifier){


    lateinit var web3j:Web3j
    lateinit var сredential:Credentials

    var connectionString by rememberSaveable{
        mutableStateOf("http://194.59.40.99:8545/")
    }

    var chainId by rememberSaveable {
        mutableStateOf("51515")
    }

    var privateKey by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier
        .padding(5.dp
        ))
    {
        TextField(value = connectionString, onValueChange = {connectionString = it})
        TextField(value = chainId, onValueChange = {chainId = it})
        TextField(value = privateKey, onValueChange = {privateKey = it})
        Button(onClick = {
            web3j = Web3j.build(HttpService(connectionString))
            try {
                val clientVersion: Web3ClientVersion = web3j.web3ClientVersion().sendAsync().get()
                if (!clientVersion.hasError()) {
                    Log.d("EtherRepositoryImpl","Connected!")
                    сredential = Credentials.create(privateKey)
                    val transactionManager: TransactionManager = RawTransactionManager(
                        web3j, сredential, chainId.toLong()
                    )
                    EtherRepositoryImpl.initialize(web3j,transactionManager,сredential,chainId.toLong())
                    navController.navigate(NavRouts.sessionChoiceScreen)
                } else {
                    Log.d("EtherRepositoryImpl",clientVersion.error.message)
                }
            } catch (e: Exception) {
                Log.d("EtherRepositoryImpl",e.message?:"Error")
            }
        }) {
            Text(text = "Connect")
        }
    }
}